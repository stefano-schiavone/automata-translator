// Generated from translator.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link translatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface translatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link translatorParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(translatorParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#packageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageClause(translatorParser.PackageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#topLevelDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDecl(translatorParser.TopLevelDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(translatorParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(translatorParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(translatorParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleReturn(translatorParser.SingleReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiReturn(translatorParser.MultiReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(translatorParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStmt(translatorParser.VarDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortVarDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortVarDeclStmt(translatorParser.ShortVarDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(translatorParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(translatorParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(translatorParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(translatorParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(translatorParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(translatorParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(translatorParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#shortVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortVarDecl(translatorParser.ShortVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(translatorParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(translatorParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(translatorParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code threePartFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreePartFor(translatorParser.ThreePartForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionFor(translatorParser.ConditionForContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(translatorParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#forPost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPost(translatorParser.ForPostContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#incDecStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecStmt(translatorParser.IncDecStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(translatorParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(translatorParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(translatorParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(translatorParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(translatorParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(translatorParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(translatorParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(translatorParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(translatorParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(translatorParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(translatorParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(translatorParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(translatorParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(translatorParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(translatorParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(translatorParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(translatorParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link translatorParser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(translatorParser.Type_Context ctx);
}