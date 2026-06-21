import org.antlr.v4.runtime.ParserRuleContext;
import java.util.*;

@SuppressWarnings("CheckReturnValue")
public class GoCTranslatorVisitor extends translatorBaseVisitor<String> {

   private int indentLevel = 0;
   private int tmpCounter = 0;

   // Maps variable names to their C types in the current scope
   private final Map<String, String> symbolTable = new HashMap<>();
   // Maps function names to their ordered C return types
   private final Map<String, List<String>> funcReturnTypes = new HashMap<>();
   // Struct typedefs emitted before any function, one per multi-return function
   private final List<String> preamble = new ArrayList<>();

   // Helpers
   private String indent() {
      return "    ".repeat(indentLevel);
   }

   private String goToCType(String goType) {
      switch (goType) {
         case "int":
            return "int";
         case "float64":
            return "double";
         case "string":
            return "char*";
         case "bool":
            return "int";
         default:
            return goType;
      }
   }

   // Type inference from Go's weird type system
   private String inferType(translatorParser.ExpressionContext ctx) {
      if (ctx instanceof translatorParser.IntExprContext)
         return "int";
      if (ctx instanceof translatorParser.FloatExprContext)
         return "double";
      if (ctx instanceof translatorParser.StringExprContext)
         return "char*";
      if (ctx instanceof translatorParser.BoolExprContext)
         return "int";
      if (ctx instanceof translatorParser.IdExprContext)
         return symbolTable.getOrDefault(ctx.getText(), "int");
      if (ctx instanceof translatorParser.CallExprContext) {
         String fn = ((translatorParser.CallExprContext) ctx).IDENTIFIER().getText();
         List<String> ret = funcReturnTypes.get(fn);
         if (ret != null && !ret.isEmpty())
            return ret.get(0);
      }
      return "int";
   }

   // Scan all function declarations to build funcReturnTypes and generate struct
   // preambles.
   private void collectSignatures(translatorParser.ProgramContext ctx) {
      for (translatorParser.TopLevelDeclContext decl : ctx.topLevelDecl()) {
         translatorParser.FunctionDeclContext fd = decl.functionDecl();
         String name = fd.IDENTIFIER().getText();
         List<String> ret = new ArrayList<>();

         if (fd.returnSignature() == null) {
            ret.add("void");
         } else if (fd.returnSignature() instanceof translatorParser.SingleReturnContext) {
            translatorParser.SingleReturnContext sr = (translatorParser.SingleReturnContext) fd.returnSignature();
            ret.add(goToCType(sr.type_().getText()));
         } else {
            translatorParser.MultiReturnContext mr = (translatorParser.MultiReturnContext) fd.returnSignature();
            for (translatorParser.Type_Context t : mr.type_())
               ret.add(goToCType(t.getText()));

            // Build typedef struct for the multi-return case
            StringBuilder struct = new StringBuilder();
            struct.append("typedef struct {\n");
            for (int i = 0; i < ret.size(); i++)
               struct.append("    ").append(ret.get(i)).append(" _").append(i).append(";\n");
            struct.append("} ").append(name).append("_result;");
            preamble.add(struct.toString());
         }
         funcReturnTypes.put(name, ret);
      }
   }

   private String stripTrailingSemi(String s) {
      return s.endsWith(";") ? s.substring(0, s.length() - 1).stripTrailing() : s;
   }

   private String enclosingFunctionName(ParserRuleContext ctx) {
      ParserRuleContext p = ctx.getParent();
      while (p != null && !(p instanceof translatorParser.FunctionDeclContext))
         p = p.getParent();
      return p != null ? ((translatorParser.FunctionDeclContext) p).IDENTIFIER().getText() : "_unknown";
   }

   // Top section of code
   @Override
   public String visitProgram(translatorParser.ProgramContext ctx) {
      collectSignatures(ctx);

      StringBuilder sb = new StringBuilder();
      sb.append("#include <stdio.h>\n\n");

      for (String s : preamble)
         sb.append(s).append("\n\n");

      for (translatorParser.TopLevelDeclContext decl : ctx.topLevelDecl())
         sb.append(visit(decl)).append("\n");

      return sb.toString();
   }

   @Override
   public String visitPackageClause(translatorParser.PackageClauseContext ctx) {
      return "";
   }

   @Override
   public String visitTopLevelDecl(translatorParser.TopLevelDeclContext ctx) {
      return visit(ctx.functionDecl());
   }

   @Override
   public String visitFunctionDecl(translatorParser.FunctionDeclContext ctx) {
      String name = ctx.IDENTIFIER().getText();
      List<String> ret = funcReturnTypes.getOrDefault(name, List.of("void"));

      String cReturn;
      if (name.equals("main"))
         cReturn = "int";
      else if (ret.size() > 1)
         cReturn = name + "_result";
      else
         cReturn = ret.get(0);

      String params = ctx.parameterList() != null ? visit(ctx.parameterList()) : "void";

      String body = visitBlockForFunc(ctx.block(), name.equals("main"));
      return cReturn + " " + name + "(" + params + ") " + body;
   }

   // Visit a block, optionally appending "return 0;" for main.
   private String visitBlockForFunc(translatorParser.BlockContext ctx, boolean isMain) {
      StringBuilder sb = new StringBuilder("{\n");
      indentLevel++;
      for (translatorParser.StatementContext stmt : ctx.statement())
         sb.append(visit(stmt));
      if (isMain)
         sb.append(indent()).append("return 0;\n");
      indentLevel--;
      sb.append(indent()).append("}");
      return sb.toString();
   }

   @Override
   public String visitBlock(translatorParser.BlockContext ctx) {
      return visitBlockForFunc(ctx, false);
   }

   // Parameters
   @Override
   public String visitParameterList(translatorParser.ParameterListContext ctx) {
      List<String> parts = new ArrayList<>();
      for (translatorParser.ParameterContext p : ctx.parameter())
         parts.add(visit(p));
      return String.join(", ", parts);
   }

   @Override
   public String visitParameter(translatorParser.ParameterContext ctx) {
      String cType = goToCType(ctx.type_().getText());
      String vName = ctx.IDENTIFIER().getText();
      symbolTable.put(vName, cType);
      return cType + " " + vName;
   }

   // Statements
   @Override
   public String visitVarDeclStmt(translatorParser.VarDeclStmtContext ctx) {
      return indent() + visit(ctx.varDecl()) + "\n";
   }

   @Override
   public String visitVarDecl(translatorParser.VarDeclContext ctx) {
      String cType = goToCType(ctx.type_().getText());
      String name = ctx.IDENTIFIER().getText();
      symbolTable.put(name, cType);
      if (ctx.expression() != null)
         return cType + " " + name + " = " + visit(ctx.expression()) + ";";
      return cType + " " + name + ";";
   }

   @Override
   public String visitShortVarDeclStmt(translatorParser.ShortVarDeclStmtContext ctx) {
      return indent() + visitShortVarDeclLines(ctx.shortVarDecl()) + "\n";
   }

   @Override
   public String visitShortVarDecl(translatorParser.ShortVarDeclContext ctx) {
      return visitShortVarDeclLines(ctx);
   }

   /**
    * Translates Go's `:=`. The interesting case is multi-return unpacking:
    * a, b := swap(x, y)
    * becomes:
    * swap_result _tmp0 = swap(x, y);
    * int a = _tmp0._0;
    * int b = _tmp0._1;
    */
   private String visitShortVarDeclLines(translatorParser.ShortVarDeclContext ctx) {
      List<String> names = new ArrayList<>();
      for (var id : ctx.IDENTIFIER())
         names.add(id.getText());
      List<translatorParser.ExpressionContext> exprs = ctx.expression();

      // Multi-return function call unpacking
      if (names.size() > 1 && exprs.size() == 1
            && exprs.get(0) instanceof translatorParser.CallExprContext) {
         String callee = ((translatorParser.CallExprContext) exprs.get(0)).IDENTIFIER().getText();
         List<String> retTypes = funcReturnTypes.get(callee);
         if (retTypes != null && retTypes.size() > 1) {
            String tmp = "_tmp" + tmpCounter++;
            StringBuilder sb = new StringBuilder();
            sb.append(callee).append("_result ").append(tmp)
                  .append(" = ").append(visit(exprs.get(0))).append(";\n");
            for (int i = 0; i < names.size(); i++) {
               String t = (i < retTypes.size()) ? retTypes.get(i) : "int";
               symbolTable.put(names.get(i), t);
               sb.append(indent()).append(t).append(" ").append(names.get(i))
                     .append(" = ").append(tmp).append("._").append(i).append(";");
               if (i < names.size() - 1)
                  sb.append("\n");
            }
            return sb.toString();
         }
      }

      // For single assignment
      if (names.size() == 1) {
         String cType = inferType(exprs.get(0));
         symbolTable.put(names.get(0), cType);
         return cType + " " + names.get(0) + " = " + visit(exprs.get(0)) + ";";
      }

      // Multiple expressions on the right (e.g. a, b := 1, 2)
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < names.size(); i++) {
         String cType = (i < exprs.size()) ? inferType(exprs.get(i)) : "int";
         symbolTable.put(names.get(i), cType);
         if (i > 0)
            sb.append("\n").append(indent());
         sb.append(cType).append(" ").append(names.get(i))
               .append(" = ").append(visit(exprs.get(i))).append(";");
      }
      return sb.toString();
   }

   @Override
   public String visitAssignStmt(translatorParser.AssignStmtContext ctx) {
      return indent() + visitAssignLines(ctx.assignment()) + "\n";
   }

   @Override
   public String visitAssignment(translatorParser.AssignmentContext ctx) {
      return visitAssignLines(ctx);
   }

   // Translates Go assignment. Parallel swap (a, b = b, a) needs temporaries so
   // both right-hand sides are evaluated before any writes.
   private String visitAssignLines(translatorParser.AssignmentContext ctx) {
      List<String> names = new ArrayList<>();
      for (var id : ctx.IDENTIFIER())
         names.add(id.getText());
      List<translatorParser.ExpressionContext> exprs = ctx.expression();

      if (names.size() == 1)
         return names.get(0) + " = " + visit(exprs.get(0)) + ";";

      // Parallel: evaluate all RHS into temporaries first
      List<String> tmps = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < exprs.size(); i++) {
         String t = "_tmp" + tmpCounter++;
         String cType = symbolTable.getOrDefault(names.get(i), "int");
         sb.append(cType).append(" ").append(t)
               .append(" = ").append(visit(exprs.get(i))).append(";\n").append(indent());
         tmps.add(t);
      }
      for (int i = 0; i < names.size(); i++) {
         sb.append(names.get(i)).append(" = ").append(tmps.get(i)).append(";");
         if (i < names.size() - 1)
            sb.append("\n").append(indent());
      }
      return sb.toString();
   }

   @Override
   public String visitIfStatement(translatorParser.IfStatementContext ctx) {
      return indent() + visit(ctx.ifStmt()) + "\n";
   }

   @Override
   public String visitIfStmt(translatorParser.IfStmtContext ctx) {
      StringBuilder sb = new StringBuilder();
      sb.append("if (").append(visit(ctx.expression())).append(") ");
      List<translatorParser.BlockContext> blocks = ctx.block();
      sb.append(visit(blocks.get(0)));
      if (ctx.ifStmt() != null)
         sb.append(" else ").append(visit(ctx.ifStmt()));
      else if (blocks.size() > 1)
         sb.append(" else ").append(visit(blocks.get(1)));
      return sb.toString();
   }

   @Override
   public String visitForStatement(translatorParser.ForStatementContext ctx) {
      return indent() + visit(ctx.forStmt()) + "\n";
   }

   @Override
   public String visitForStmt(translatorParser.ForStmtContext ctx) {
      if (ctx.forClause() == null)
         return "for (;;) " + visit(ctx.block());
      return visit(ctx.forClause()) + " " + visit(ctx.block());
   }

   // Three-part for: "for i := 0; i < n; i++" → "for (int i = 0; i < n; i++)". The
   // initialiser already includes a semicolon from the inner rule so we can strip
   // it
   @Override
   public String visitThreePartFor(translatorParser.ThreePartForContext ctx) {
      String init = ctx.forInit() != null ? stripTrailingSemi(visit(ctx.forInit())) : "";
      String cond = ctx.expression() != null ? visit(ctx.expression()) : "";
      String post = ctx.forPost() != null ? stripTrailingSemi(visit(ctx.forPost())) : "";
      return "for (" + init + "; " + cond + "; " + post + ")";
   }

   // Go condition-only "for" maps to C "while".
   @Override
   public String visitConditionFor(translatorParser.ConditionForContext ctx) {
      return "while (" + visit(ctx.expression()) + ")";
   }

   @Override
   public String visitForInit(translatorParser.ForInitContext ctx) {
      if (ctx.shortVarDecl() != null)
         return visit(ctx.shortVarDecl());
      return visit(ctx.assignment());
   }

   @Override
   public String visitForPost(translatorParser.ForPostContext ctx) {
      if (ctx.incDecStmt() != null)
         return visit(ctx.incDecStmt());
      return visit(ctx.assignment());
   }

   @Override
   public String visitIncDecStmt(translatorParser.IncDecStmtContext ctx) {
      return ctx.IDENTIFIER().getText() + ctx.getChild(1).getText();
   }

   @Override
   public String visitReturnStatement(translatorParser.ReturnStatementContext ctx) {
      return indent() + visit(ctx.returnStmt()) + "\n";
   }

   /**
    * Multi-return: `return a, b` → `return (funcname_result){a, b};`
    *
    * The struct type name is found by walking up the parse tree to the enclosing
    * function.
    */
   @Override
   public String visitReturnStmt(translatorParser.ReturnStmtContext ctx) {
      List<translatorParser.ExpressionContext> exprs = ctx.expression();
      if (exprs.isEmpty())
         return "return;";
      if (exprs.size() == 1)
         return "return " + visit(exprs.get(0)) + ";";

      String funcName = enclosingFunctionName(ctx);
      List<String> vals = new ArrayList<>();
      for (var e : exprs)
         vals.add(visit(e));
      return "return (" + funcName + "_result){" + String.join(", ", vals) + "};";
   }

   @Override
   public String visitPrintStatement(translatorParser.PrintStatementContext ctx) {
      return indent() + visit(ctx.printStmt()) + "\n";
   }

   /**
    * fmt.Printf → printf (format string kept as-is).
    * fmt.Println → printf with space-separated args and trailing \n.
    * fmt.Print → printf with space-separated args, no trailing \n.
    */
   @Override
   public String visitPrintStmt(translatorParser.PrintStmtContext ctx) {
      String fn = ctx.getChild(2).getText(); // Println / Printf / Print
      List<translatorParser.ExpressionContext> args = ctx.argumentList() != null ? ctx.argumentList().expression()
            : List.of();

      if (fn.equals("Printf")) {
         List<String> parts = new ArrayList<>();
         for (var a : args)
            parts.add(visit(a));
         return "printf(" + String.join(", ", parts) + ");";
      }

      boolean newline = fn.equals("Println");

      if (args.isEmpty())
         return "printf(\"" + (newline ? "\\n" : "") + "\");";

      StringBuilder fmt = new StringBuilder("\"");
      List<String> rest = new ArrayList<>();
      boolean first = true;
      for (var arg : args) {
         if (!first && newline)
            fmt.append(" ");
         first = false;
         if (arg instanceof translatorParser.StringExprContext) {
            // Embed Go string literal content directly in the format string
            String raw = arg.getText();
            fmt.append(raw, 1, raw.length() - 1);
         } else {
            String t = inferType(arg);
            fmt.append(t.equals("double") ? "%f" : t.equals("char*") ? "%s" : "%d");
            rest.add(visit(arg));
         }
      }
      if (newline)
         fmt.append("\\n");
      fmt.append("\"");

      if (rest.isEmpty())
         return "printf(" + fmt + ");";
      return "printf(" + fmt + ", " + String.join(", ", rest) + ");";
   }

   @Override
   public String visitExprStmt(translatorParser.ExprStmtContext ctx) {
      return indent() + visit(ctx.expression()) + ";\n";
   }

   // Expressions

   @Override
   public String visitParenExpr(translatorParser.ParenExprContext ctx) {
      return "(" + visit(ctx.expression()) + ")";
   }

   @Override
   public String visitCallExpr(translatorParser.CallExprContext ctx) {
      String args = ctx.argumentList() != null ? visit(ctx.argumentList()) : "";
      return ctx.IDENTIFIER().getText() + "(" + args + ")";
   }

   @Override
   public String visitUnaryExpr(translatorParser.UnaryExprContext ctx) {
      return ctx.getChild(0).getText() + visit(ctx.expression());
   }

   @Override
   public String visitMulExpr(translatorParser.MulExprContext ctx) {
      return visit(ctx.expression(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.expression(1));
   }

   @Override
   public String visitAddExpr(translatorParser.AddExprContext ctx) {
      return visit(ctx.expression(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.expression(1));
   }

   @Override
   public String visitRelExpr(translatorParser.RelExprContext ctx) {
      return visit(ctx.expression(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.expression(1));
   }

   @Override
   public String visitEqExpr(translatorParser.EqExprContext ctx) {
      return visit(ctx.expression(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.expression(1));
   }

   @Override
   public String visitAndExpr(translatorParser.AndExprContext ctx) {
      return visit(ctx.expression(0)) + " && " + visit(ctx.expression(1));
   }

   @Override
   public String visitOrExpr(translatorParser.OrExprContext ctx) {
      return visit(ctx.expression(0)) + " || " + visit(ctx.expression(1));
   }

   @Override
   public String visitIdExpr(translatorParser.IdExprContext ctx) {
      return ctx.IDENTIFIER().getText();
   }

   @Override
   public String visitIntExpr(translatorParser.IntExprContext ctx) {
      return ctx.INT_LIT().getText();
   }

   @Override
   public String visitFloatExpr(translatorParser.FloatExprContext ctx) {
      return ctx.FLOAT_LIT().getText();
   }

   @Override
   public String visitStringExpr(translatorParser.StringExprContext ctx) {
      return ctx.STRING_LIT().getText();
   }

   @Override
   public String visitBoolExpr(translatorParser.BoolExprContext ctx) {
      return ctx.getText().equals("true") ? "1" : "0";
   }

   @Override
   public String visitArgumentList(translatorParser.ArgumentListContext ctx) {
      List<String> parts = new ArrayList<>();
      for (var e : ctx.expression())
         parts.add(visit(e));
      return String.join(", ", parts);
   }

   @Override
   public String visitType_(translatorParser.Type_Context ctx) {
      return goToCType(ctx.getText());
   }

   @Override
   public String visitSingleReturn(translatorParser.SingleReturnContext ctx) {
      return goToCType(ctx.type_().getText());
   }

   @Override
   public String visitMultiReturn(translatorParser.MultiReturnContext ctx) {
      List<String> types = new ArrayList<>();
      for (var t : ctx.type_())
         types.add(goToCType(t.getText()));
      return String.join(", ", types);
   }
}
