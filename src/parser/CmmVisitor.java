// Generated from /Users/masters/Projects/C--Compiler/src/parser/Cmm.g4 by ANTLR 4.13.2
package parser;

	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.locatable.*;
	import ast.statements.*;
	import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#procedureInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureInvocation(CmmParser.ProcedureInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#varDefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefList(CmmParser.VarDefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#arrayIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndex(CmmParser.ArrayIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#stmtBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBlock(CmmParser.StmtBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CmmParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmmParser.TypeContext ctx);
}