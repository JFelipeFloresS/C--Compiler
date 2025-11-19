package ast.expressions;

import visitor.Visitor;

import java.util.Objects;

public class ArrayAccess extends AbstractExpression {

	private final Expression array;
	private final Expression index;

	public ArrayAccess(int line, int column, Expression array, Expression index) {
		super(line, column);
		this.array = array;
		this.index = index;
	}

	public Expression getArray() {
		return array;
	}

	public Expression getIndex() {
		return index;
	}

	@Override
	public String toString() {
		String indexStr = (index != null) ? index.toString() : "null";
		return String.format(
			"ArrayAccess (%d, %d):%n\t" +
				"array: %s%n\t" +
				"index: %s",
			getLine(),
			getColumn(),
			array.getClass().getSimpleName(),
			indexStr
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ArrayAccess that)) {
			System.out.println("Not ArrayAccess instance compare: " + o.getClass().getSimpleName());
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("ArrayAccess Line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("ArrayAccess Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (!Objects.deepEquals(this.getArray(), that.getArray())) {
			System.out.println("ArrayAccess Arrays differ: " + this.getArray() + " != " + that.getArray());
			return false;
		}

		if ((this.getIndex() == null && that.getIndex() != null) || (this.getIndex() != null && that.getIndex() == null)) {
			System.out.println("ArrayAccess Index differs: " + this.getIndex() + " != " + that.getIndex());
			return false;
		}

		if (this.getIndex() != null && that.getIndex() != null && !Objects.deepEquals(this.getIndex(), that.getIndex())) {
			System.out.println("ArrayAccess Indexes differ: " + this.getIndex() + " != " + that.getIndex());
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(array, index);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
