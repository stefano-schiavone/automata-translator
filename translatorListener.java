// Generated from translator.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link translatorParser}.
 */
public interface translatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link translatorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(translatorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(translatorParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#packageClause}.
	 * @param ctx the parse tree
	 */
	void enterPackageClause(translatorParser.PackageClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#packageClause}.
	 * @param ctx the parse tree
	 */
	void exitPackageClause(translatorParser.PackageClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(translatorParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(translatorParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(translatorParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(translatorParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(translatorParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(translatorParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(translatorParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(translatorParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 */
	void enterSingleReturn(translatorParser.SingleReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 */
	void exitSingleReturn(translatorParser.SingleReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 */
	void enterMultiReturn(translatorParser.MultiReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiReturn}
	 * labeled alternative in {@link translatorParser#returnSignature}.
	 * @param ctx the parse tree
	 */
	void exitMultiReturn(translatorParser.MultiReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(translatorParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(translatorParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStmt(translatorParser.VarDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStmt(translatorParser.VarDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shortVarDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShortVarDeclStmt(translatorParser.ShortVarDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shortVarDeclStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShortVarDeclStmt(translatorParser.ShortVarDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(translatorParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(translatorParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(translatorParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(translatorParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(translatorParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(translatorParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(translatorParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(translatorParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(translatorParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(translatorParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(translatorParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link translatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(translatorParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(translatorParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(translatorParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#shortVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterShortVarDecl(translatorParser.ShortVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#shortVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitShortVarDecl(translatorParser.ShortVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(translatorParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(translatorParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(translatorParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(translatorParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(translatorParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(translatorParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code threePartFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterThreePartFor(translatorParser.ThreePartForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code threePartFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitThreePartFor(translatorParser.ThreePartForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterConditionFor(translatorParser.ConditionForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionFor}
	 * labeled alternative in {@link translatorParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitConditionFor(translatorParser.ConditionForContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(translatorParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(translatorParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#forPost}.
	 * @param ctx the parse tree
	 */
	void enterForPost(translatorParser.ForPostContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#forPost}.
	 * @param ctx the parse tree
	 */
	void exitForPost(translatorParser.ForPostContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#incDecStmt}.
	 * @param ctx the parse tree
	 */
	void enterIncDecStmt(translatorParser.IncDecStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#incDecStmt}.
	 * @param ctx the parse tree
	 */
	void exitIncDecStmt(translatorParser.IncDecStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(translatorParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(translatorParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(translatorParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(translatorParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(translatorParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(translatorParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(translatorParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(translatorParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(translatorParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(translatorParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(translatorParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(translatorParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(translatorParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(translatorParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(translatorParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(translatorParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(translatorParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(translatorParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(translatorParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(translatorParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(translatorParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(translatorParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(translatorParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(translatorParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(translatorParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(translatorParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(translatorParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(translatorParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(translatorParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(translatorParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(translatorParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(translatorParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(translatorParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link translatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(translatorParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link translatorParser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(translatorParser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link translatorParser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(translatorParser.Type_Context ctx);
}