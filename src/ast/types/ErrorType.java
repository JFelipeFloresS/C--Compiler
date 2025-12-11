package ast.types;

import ast.locatable.Locatable;
import error_handler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType {

	private final String message;

	public ErrorType(String message, Locatable node) {
		super(node.getLine(), node.getColumn());
		this.message = message;

		ErrorHandler.getErrorHandler().addError(this);
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public Type arithmetic(Type that, Locatable node) {
		return this;
	}

	@Override
	public Type assignment(Type that, Locatable node) {
		return this;
	}

	@Override
	public Type cast(Type that, Locatable node) {
		return this;
	}

	@Override
	public Type relational(Type that, Locatable node) {
		return this;
	}

	@Override
	public Type logical(Type that, Locatable node) {
		return this;
	}

	@Override
	public Type squareBrackets(Type type) {
		return this;
	}

	@Override
	public String toString() {
		return String.format("Error (%d, %d): %s", getLine(), getColumn(), message);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) {
			System.out.println("Comparing ErrorType with null");
			return false;
		}
		if (!(o instanceof ErrorType that)) {
			System.out.println("Comparing ErrorType with non-ErrorType " + o.getClass().getSimpleName());
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("ErrorType line mismatch: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("ErrorType column mismatch: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (!this.message.equals(that.message)) {
			System.out.println("ErrorType message mismatch: \"" + this.message + "\" != \"" + that.message + "\"");
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return 42; // All ErrorType instances are considered equal
	}

	@Override
	public char suffix() {
		throw new RuntimeException("Do not call suffix on ErrorType");
	}

	@Override
	public int numberOfBytes() {
		return 0;
	}
}
