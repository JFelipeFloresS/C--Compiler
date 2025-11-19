package ast.expressions;

import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression {

	private final double value;

	public DoubleLiteral(int line, int column, double value) {
		super(line, column);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format(
			"DoubleLiteral (%d, %d):%n\t" +
				"value: %f",
			this.getLine(),
			this.getColumn(),
			value
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DoubleLiteral that)) {
			System.out.println("Not a DoubleLiteral instance");
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("DoubleLiteral Line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("DoubleLiteral Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (this.getValue() != that.getValue()) {
			System.out.println("DoubleLiteral Values differ: " + this.getValue() + " != " + that.getValue());
			return false;
		}

		if (!(this.getType() != null ? this.getType().equals(that.getType()) : that.getType() == null)) {
			System.out.println("DoubleLiteral Types differ: " + this.getType() + " != " + that.getType());
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(getLine());
		result = 31 * result + Integer.hashCode(getColumn());
		result = 31 * result + Double.hashCode(value);
		result = 31 * result + (getType() != null ? getType().hashCode() : 0);
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
