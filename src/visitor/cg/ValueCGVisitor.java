package visitor.cg;

import ast.expressions.*;
import ast.types.CharType;
import cg.CG;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {
	private final AddressCGVisitor addressCGVisitor;

	public ValueCGVisitor(CG cg) {
		super(cg);
		this.addressCGVisitor = new AddressCGVisitor(cg);
	}

	@Override
	public Void visit(Arithmetic arithmetic, Void param) {
		arithmetic.getLeft().accept(this, null);
		if (arithmetic.getLeft().getType() instanceof CharType && arithmetic.getRight().getType() instanceof CharType) {
			cg.cast(arithmetic.getLeft().getType(), arithmetic.getType());
		}
		arithmetic.getRight().accept(this, null);
		if (arithmetic.getLeft().getType() instanceof CharType && arithmetic.getRight().getType() instanceof CharType) {
			cg.cast(arithmetic.getRight().getType(), arithmetic.getType());
		}
		cg.arithmetic(arithmetic.getOperator(), arithmetic.getType());
		return null;
	}

	@Override
	public Void visit(Modulus modulus, Void param) {
		modulus.getLeft().accept(this, null);
		modulus.getRight().accept(this, null);
		cg.mod(modulus.getType());
		return null;
	}

	@Override
	public Void visit(Relational relational, Void param) {
		relational.getLeft().accept(this, null);
		relational.getRight().accept(this, null);
		cg.relational(relational.getOperator(), relational.getType());
		return null;
	}

	@Override
	public Void visit(Logical logical, Void param) {
		logical.getLeft().accept(this, null);
		logical.getRight().accept(this, null);
		cg.logical(logical.getOperator());
		return null;
	}

	@Override
	public Void visit(LogicalNot logicalNot, Void param) {
		logicalNot.getExpression().accept(this, null);
		cg.logicalNot();
		return null;
	}

	@Override
	public Void visit(Id variable, Void param) {
		variable.accept(this.addressCGVisitor, null);
		cg.load(variable.getType());
		return null;
	}

	@Override
	public Void visit(IntLiteral intLiteral, Void param) {
		cg.push(intLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(DoubleLiteral realLiteral, Void param) {
		cg.push(realLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(CharLiteral charLiteral, Void param) {
		cg.push(charLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(Cast cast, Void param) {
		cast.getExpression().accept(this, null);
		cg.cast(cast.getExpression().getType(), cast.getType());
		return null;
	}
}
