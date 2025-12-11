package ast.expressions;

import visitor.Visitor;

public class Modulus extends AbstractBinaryExpression {

	public Modulus(int line, int col, Expression left, Expression right) {
		super(line, col, left, "%", right);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
