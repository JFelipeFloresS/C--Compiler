// Generated from /Users/masters/Projects/C--Compiler/src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CmmParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#procedureInvocation}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureInvocation(CmmParser.ProcedureInvocationContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#definition}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(CmmParser.DefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#varDefinition}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(CmmParser.VarDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#varDefList}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefList(CmmParser.VarDefListContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#functionDefinition}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#paramsList}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsList(CmmParser.ParamsListContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#paramDef}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDef(CmmParser.ParamDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#recordFieldList}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordFieldList(CmmParser.RecordFieldListContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#recordField}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordField(CmmParser.RecordFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#stmtBlock}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBlock(CmmParser.StmtBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#stmtList}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(CmmParser.StmtListContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#expression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmmParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#logicalOrExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(CmmParser.LogicalOrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#logicalAndExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(CmmParser.LogicalAndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#relationalExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(CmmParser.RelationalExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#additiveExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(CmmParser.AdditiveExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#multiplicativeExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(CmmParser.MultiplicativeExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#unaryExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(CmmParser.UnaryExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#accessExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpression(CmmParser.AccessExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#primaryExpression}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(CmmParser.PrimaryExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#expressionList}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CmmParser.ExpressionListContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#functionInvocation}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(CmmParser.FunctionInvocationContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#voidableType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidableType(CmmParser.VoidableTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#arrayableType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayableType(CmmParser.ArrayableTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link CmmParser#builtInType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInType(CmmParser.BuiltInTypeContext ctx);
}