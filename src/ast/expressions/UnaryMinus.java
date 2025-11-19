package ast.expressions;

import visitor.Visitor;

public class UnaryMinus extends AbstractExpression {

	private final Expression expression;

	public UnaryMinus(int line, int column, Expression expression) {
		super(line, column);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		return String.format(
			"UnaryMinus:%s" +
				"expression: %s",
			"\n\t",
			expression.getClass().getSimpleName()
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof UnaryMinus that)) return false;
		if (this.getLine() != that.getLine()) return false;
		if (this.getColumn() != that.getColumn()) return false;
		return this.expression.equals(that.expression);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.getLine();
		result = 31 * result + this.getColumn();
		result = 31 * result + this.expression.hashCode();
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
