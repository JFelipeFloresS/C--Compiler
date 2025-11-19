package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class IfElse extends AbstractStatement {

	private final Expression condition;
	private final List<Statement> thenStatements;
	private final List<Statement> elseStatements;

	public IfElse(int line, int column, Expression condition, List<Statement> thenStatements, List<Statement> elseStatements) {
		super(line, column);
		this.condition = condition;
		this.thenStatements = thenStatements;
		this.elseStatements = elseStatements;
	}

	public List<Statement> getElseStatements() {
		return elseStatements;
	}

	public List<Statement> getThenStatements() {
		return thenStatements;
	}

	public Expression getCondition() {
		return condition;
	}

	@Override
	public String toString() {
		String thenClasses = thenStatements != null ? String.join(", ", thenStatements.stream().map(stmt -> stmt.getClass().getSimpleName()).toArray(String[]::new)) : "null";
		String elseClasses = elseStatements != null ? String.join(", ", elseStatements.stream().map(stmt -> stmt.getClass().getSimpleName()).toArray(String[]::new)) : "null";
		return String.format(
			"IfElse (%d, %d):%n\t" +
				"condition: %s%n\t" +
				"thenStatements: %s%n\t" +
				"elseStatements: %s",
			getLine(),
			getColumn(),
			condition.getClass().getSimpleName(),
			thenClasses,
			elseClasses
		);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IfElse that)) {
			System.out.println("Not IfElse instance");
			return false;
		}
		if (this.getLine() != that.getLine()) {
			System.out.println("IfElse line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}
		if (this.getColumn() != that.getColumn()) {
			System.out.println("IfElse column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}
		if (!this.condition.equals(that.condition)) {
			System.out.println("IfElse conditions differ: " + this.condition + " != " + that.condition);
			return false;
		}
		if (this.thenStatements.size() != that.thenStatements.size()) {
			System.out.println("IfElse thenStatements size differ: " + this.thenStatements.size() + " != " + that.thenStatements.size());
			return false;
		}
		for (int i = 0; i < this.thenStatements.size(); i++) {
			if (!this.thenStatements.get(i).equals(that.thenStatements.get(i))) {
				System.out.println("IfElse thenStatements at index " + i + " differ: " + this.thenStatements.get(i) + " != " + that.thenStatements.get(i));
				return false;
			}
		}
		if ((this.elseStatements == null) != (that.elseStatements == null)) {
			System.out.println("IfElse elseStatements nullity differ: " + (this.elseStatements == null) + " != " + (that.elseStatements == null));
			return false;
		}
		if (this.elseStatements != null) {
			if (this.elseStatements.size() != that.elseStatements.size()) {
				System.out.println("IfElse elseStatements size differ: " + this.elseStatements.size() + " != " + that.elseStatements.size());
				return false;
			}
			for (int i = 0; i < this.elseStatements.size(); i++) {
				if (!this.elseStatements.get(i).equals(that.elseStatements.get(i))) {
					System.out.println("IfElse elseStatements at index " + i + " differ: " + this.elseStatements.get(i) + " != " + that.elseStatements.get(i));
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(getLine());
		result = 31 * result + Integer.hashCode(getColumn());
		result = 31 * result + condition.hashCode();
		for (Statement stmt : thenStatements) {
			result = 31 * result + stmt.hashCode();
		}
		if (elseStatements != null) {
			for (Statement stmt : elseStatements) {
				result = 31 * result + stmt.hashCode();
			}
		}
		return result;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
}
