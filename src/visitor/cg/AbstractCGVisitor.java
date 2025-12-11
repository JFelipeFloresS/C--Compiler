package visitor.cg;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import cg.CG;
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

	/**
	 * Handles the code generation responsibilities
	 */
	protected CG cg;

	public AbstractCGVisitor(CG cg) {
		this.cg = cg;
	}

	public CG getCG() {
		return this.cg;
	}

	@Override
	public TR visit(FunctionDefinition funcDef, TP param) {
		throw new IllegalStateException("Code generation template \"FunctionDefinition\" not defined for the code function" + this.getClass().getName());
	}

	@Override
	public TR visit(VariableDefinition varDef, TP param) {
		throw new IllegalStateException("Code generation template \"VariableDefinition\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Assignment assignment, TP param) {
		throw new IllegalStateException("Code generation template \"Assignment\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(IfElse ifElse, TP param) {
		throw new IllegalStateException("Code generation template \"IfElse\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(ProcedureInvocation invocation, TP param) {
		throw new IllegalStateException("Code generation template \"ProcedureInvocation\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Read read, TP param) {
		throw new IllegalStateException("Code generation template \"Read\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Return _return, TP param) {
		throw new IllegalStateException("Code generation template \"Return\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(While write, TP param) {
		throw new IllegalStateException("Code generation template \"While\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Write write, TP param) {
		throw new IllegalStateException("Code generation template \"Write\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Arithmetic arithmetic, TP param) {
		throw new IllegalStateException("Code generation template \"Arithmetic\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(ArrayAccess arrayAccess, TP param) {
		throw new IllegalStateException("Code generation template \"ArrayAccess\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Cast cast, TP param) {
		throw new IllegalStateException("Code generation template \"Cast\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(CharLiteral charLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"CharLiteral\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(DoubleLiteral doubleLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"DoubleLiteral\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(FunctionInvocation functionInvocation, TP param) {
		throw new IllegalStateException("Code generation template \"FunctionInvocation\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Id id, TP param) {
		throw new IllegalStateException("Code generation template \"Id\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(IntLiteral intLiteral, TP param) {
		throw new IllegalStateException("Code generation template \"IntLiteral\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Logical logical, TP param) {
		throw new IllegalStateException("Code generation template \"Logical\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(LogicalNot logicalNot, TP param) {
		throw new IllegalStateException("Code generation template \"LogicalNot\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Modulus modulus, TP param) {
		throw new IllegalStateException("Code generation template \"Modulus\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Parenthesis parenthesis, TP param) {
		throw new IllegalStateException("Code generation template \"Parenthesis\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(Relational relational, TP param) {
		throw new IllegalStateException("Code generation template \"Relational\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(StructAccess structAccess, TP param) {
		throw new IllegalStateException("Code generation template \"StructAccess\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(UnaryMinus unaryMinus, TP param) {
		throw new IllegalStateException("Code generation template \"UnaryMinus\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(StructRecordField recordField, TP param) {
		throw new IllegalStateException("Code generation template \"StructRecordField\" not defined for the code function " + this.getClass().getName());
	}

	@Override
	public TR visit(CharType charType, TP param) {
		throw new IllegalStateException("Code generation template \"CharType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(DoubleType doubleType, TP param) {
		throw new IllegalStateException("Code generation template \"DoubleType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(IntType intType, TP param) {
		throw new IllegalStateException("Code generation template \"IntType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(ArrayType arrayType, TP param) {
		throw new IllegalStateException("Code generation template \"ArrayType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(StructType structType, TP param) {
		throw new IllegalStateException("Code generation template \"StructType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(VoidType voidType, TP param) {
		throw new IllegalStateException("Code generation template \"VoidType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(FunctionType functionType, TP param) {
		throw new IllegalStateException("Code generation template \"FunctionType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(ErrorType errorType, TP param) {
		throw new IllegalStateException("Code generation template \"ErrorType\" not defined for the code function " +
			this.getClass().getName());
	}

	@Override
	public TR visit(Program program, TP param) {
		throw new IllegalStateException("Code generation template \"Program\" not defined for the code function " +
			this.getClass().getName());
	}
}
