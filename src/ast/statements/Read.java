package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class Read extends AbstractStatement {

	private final List<Expression> expressions;

	public Read(int line, int column, List<Expression> expressions) {
		super(line, column);
		this.expressions = expressions;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	@Override
	public String toString() {
		String exprString = String.join(", ", expressions.stream().map(e -> e.getClass().getSimpleName()).toArray(String[]::new));
		return String.format(
			"Read (%d, %d):%n\t" +
				"expressions: %s",
			this.getLine(),
			this.getColumn(),
			exprString
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Read that)) {
			System.out.println("Not Read instance");
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("Read Line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}

		if (this.getColumn() != that.getColumn()) {
			System.out.println("Read Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}

		if (this.expressions.size() != that.expressions.size()) {
			System.out.println("Read expressions size differ: " + this.expressions.size() + " != " + that.expressions.size());
			return false;
		}

		for (int i = 0; i < this.expressions.size(); i++) {
			if (!this.expressions.get(i).equals(that.expressions.get(i))) {
				System.out.println("Read expressions at index " + i + " differ: " + this.expressions.get(i) + " != " + that.expressions.get(i));
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(getLine());
		result = 31 * result + Integer.hashCode(getColumn());
		for (Expression expr : expressions) {
			result = 31 * result + expr.hashCode();
		}
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
