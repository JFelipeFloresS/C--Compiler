package ast.expressions;

import visitor.Visitor;

public class IntLiteral extends AbstractExpression {

	private final int value;

	public IntLiteral(int line, int column, int value) {
		super(line, column);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format(
			"IntLiteral:%s" +
				"value: %d",
			"\n\t",
			this.value
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IntLiteral that)) {
			System.out.println("Not Instance of IntLiteral");
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("IntLiteral Line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("IntLiteral Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (this.value != that.value) {
			System.out.println("IntLiteral values differ: " + this.value + " != " + that.value);
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(getLine());
		result = 31 * result + Integer.hashCode(getColumn());
		result = 31 * result + Integer.hashCode(value);
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
