// Generated from /Users/masters/Projects/lab05/src/parser/Cmm.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link CmmParser#arrayIndex}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndex(CmmParser.ArrayIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#arrayIndex}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndex(CmmParser.ArrayIndexContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CmmParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmmParser.TypeContext ctx);
}