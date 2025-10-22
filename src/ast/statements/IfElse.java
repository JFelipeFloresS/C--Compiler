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
                "IfElse:%s" +
                "condition: %s%s" +
                "thenStatements: %s%s" +
                "elseStatements: %s",
                "\n\t",
                condition.getClass().getSimpleName(), "\n\t",
                thenClasses, "\n\t",
                elseClasses
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IfElse that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.condition.equals(that.condition)) return false;
        if (this.thenStatements.size() != that.thenStatements.size()) return false;
        for (int i = 0; i < this.thenStatements.size(); i++) {
            if (!this.thenStatements.get(i).equals(that.thenStatements.get(i))) return false;
        }
        if ( (this.elseStatements == null) != (that.elseStatements == null) ) return false;
        if (this.elseStatements != null) {
            if (this.elseStatements.size() != that.elseStatements.size()) return false;
            for (int i = 0; i < this.elseStatements.size(); i++) {
                if (!this.elseStatements.get(i).equals(that.elseStatements.get(i))) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getLine();
        result = 31 * result + getColumn();
        result = 31 * result + condition.hashCode();
        result = 31 * result + thenStatements.hashCode();
        result = 31 * result + elseStatements.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
