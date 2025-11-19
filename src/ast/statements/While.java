package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class While extends AbstractStatement {

	private final Expression condition;
	private final List<Statement> thenStatements;

	public While(int line, int column, Expression condition, List<Statement> thenStatements) {
		super(line, column);
		this.condition = condition;
		this.thenStatements = thenStatements;
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Statement> getThenStatements() {
		return thenStatements;
	}

	@Override
	public String toString() {
		String thenClasses = thenStatements != null ? String.join(", ", thenStatements.stream().map(stmt -> stmt.getClass().getSimpleName()).toArray(String[]::new)) : "null";
		return String.format(
			"While (%d, %d):%n\t" +
				"condition: %s%n\t" +
				"thenStatements: %s",
			getLine(),
			getColumn(),
			condition.getClass().getSimpleName(),
			thenClasses
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof While that)) {
			System.out.println("Not While instance");
			return false;
		}
		if (this.getLine() != that.getLine()) {
			System.out.println("While line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}
		if (this.getColumn() != that.getColumn()) {
			System.out.println("While column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}
		if (!this.condition.equals(that.condition)) {
			System.out.println("While conditions differ: " + this.condition + " != " + that.condition);
			return false;
		}
		if (this.thenStatements.size() != that.thenStatements.size()) {
			System.out.println("While thenStatements size differ: " + this.thenStatements.size() + " != " + that.thenStatements.size());
			return false;
		}
		for (int i = 0; i < this.thenStatements.size(); i++) {
			if (!this.thenStatements.get(i).equals(that.thenStatements.get(i))) {
				System.out.println("While thenStatements at index " + i + " differ: " + this.thenStatements.get(i) + " != " + that.thenStatements.get(i));
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.getLine();
		result = 31 * result + this.getColumn();
		result = 31 * result + this.condition.hashCode();
		result = 31 * result + this.thenStatements.hashCode();
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
