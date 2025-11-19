// Generated from /Users/masters/Projects/C--Compiler/src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

	import ast.*;
	import ast.definitions.*;
    import ast.expressions.*;
    import ast.locatable.*;
    import ast.statements.*;
    import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#procedureInvocation}.
	 * @param ctx the parse tree
	 */
	void enterProcedureInvocation(CmmParser.ProcedureInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#procedureInvocation}.
	 * @param ctx the parse tree
	 */
	void exitProcedureInvocation(CmmParser.ProcedureInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#varDefList}.
	 * @param ctx the parse tree
	 */
	void enterVarDefList(CmmParser.VarDefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#varDefList}.
	 * @param ctx the parse tree
	 */
	void exitVarDefList(CmmParser.VarDefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void enterParamsList(CmmParser.ParamsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void exitParamsList(CmmParser.ParamsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#paramDef}.
	 * @param ctx the parse tree
	 */
	void enterParamDef(CmmParser.ParamDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#paramDef}.
	 * @param ctx the parse tree
	 */
	void exitParamDef(CmmParser.ParamDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#recordFieldList}.
	 * @param ctx the parse tree
	 */
	void enterRecordFieldList(CmmParser.RecordFieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#recordFieldList}.
	 * @param ctx the parse tree
	 */
	void exitRecordFieldList(CmmParser.RecordFieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#recordField}.
	 * @param ctx the parse tree
	 */
	void enterRecordField(CmmParser.RecordFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#recordField}.
	 * @param ctx the parse tree
	 */
	void exitRecordField(CmmParser.RecordFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void enterStmtBlock(CmmParser.StmtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void exitStmtBlock(CmmParser.StmtBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignableExpression(CmmParser.AssignableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignableExpression(CmmParser.AssignableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(CmmParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(CmmParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#assignableExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterAssignableExpressionList(CmmParser.AssignableExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#assignableExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitAssignableExpressionList(CmmParser.AssignableExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#voidableType}.
	 * @param ctx the parse tree
	 */
	void enterVoidableType(CmmParser.VoidableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#voidableType}.
	 * @param ctx the parse tree
	 */
	void exitVoidableType(CmmParser.VoidableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#arrayableType}.
	 * @param ctx the parse tree
	 */
	void enterArrayableType(CmmParser.ArrayableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#arrayableType}.
	 * @param ctx the parse tree
	 */
	void exitArrayableType(CmmParser.ArrayableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(CmmParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(CmmParser.BuiltInTypeContext ctx);
}