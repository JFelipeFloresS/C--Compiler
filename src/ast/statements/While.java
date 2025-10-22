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
                "While:%s" +
                "condition: %s%s" +
                "thenStatements: %s",
                "\n\t",
                condition.getClass().getSimpleName(), "\n\t",
                thenClasses
        );
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof While that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (! this.condition.equals(that.condition)) return false;
        if (this.thenStatements.size() != that.thenStatements.size()) return false;
        for (int i = 0; i < this.thenStatements.size(); i++) {
            if (!this.thenStatements.get(i).equals(that.thenStatements.get(i))) return false;
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
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
