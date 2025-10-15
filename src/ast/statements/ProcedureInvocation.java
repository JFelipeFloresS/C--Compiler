package ast.statements;

import ast.expressions.Expression;

import java.util.List;

public class ProcedureInvocation extends AbstractStatement {

    private final String procedureName;
    private final List<Expression> parameters;

    public ProcedureInvocation(int line, int column, String procedureName, List<Expression> parameters) {
        super(line, column);
        this.procedureName = procedureName;
        this.parameters = parameters;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        String paramString = String.join(", ", parameters.stream().map(p -> p.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
                "ProcedureInvocation:%s" +
                "procedureName: %s%s" +
                "parameters: %s",
                "\n\t",
                procedureName, "\n\t",
                paramString
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProcedureInvocation that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.procedureName.equals(that.procedureName)) return false;
        if (this.parameters.size() != that.parameters.size()) return false;
        for (int i = 0; i < this.parameters.size(); i++) {
            if (!this.parameters.get(i).equals(that.parameters.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = procedureName.hashCode();
        for (Expression param : parameters) {
            result = 31 * result + param.hashCode();
        }
        result = 31 * result + getLine();
        result = 31 * result + getColumn();
        return result;
    }
}
