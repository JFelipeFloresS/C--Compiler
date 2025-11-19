package ast.types;

import visitor.Visitor;

public class VoidType extends AbstractType {
	public VoidType(int line, int column) {
		super(line, column);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return String.format("void (%d, %d)",
			this.getLine(),
			this.getColumn());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof VoidType that)) {
			System.out.printf("Not a VoidType instance (%d, %d)%n", this.getLine(), this.getColumn());
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("VoidType line number differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("VoidType column number differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return 31 * getLine() + getColumn();
	}
}
