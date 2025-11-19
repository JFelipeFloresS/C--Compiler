package ast.expressions;

import ast.types.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

	private final Expression expression;

	public Cast(int line, int column, Type type, Expression expression) {
		super(line, column);
		this.setType(type);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		return String.format(
			"Cast:%s" +
				"type: %s%s" +
				"expression: %s",
			"\n\t",
			this.getType().toString(), "\n\t",
			expression.getClass().getSimpleName()
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cast that)) {
			System.out.println("Not Cast instance");
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("Cast Line numbers mismatch: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("Cast Column numbers mismatch: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (!this.getType().equals(that.getType())) {
			System.out.println("Cast Types mismatch: " + this.getType() + " != " + that.getType());
			return false;
		}

		if (!this.expression.equals(that.expression)) {
			System.out.println("Cast Expressions mismatch: " + this.expression + " != " + that.expression);
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.getLine();
		result = 31 * result + this.getColumn();
		result = 31 * result + this.getType().hashCode();
		result = 31 * result + this.expression.hashCode();
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
