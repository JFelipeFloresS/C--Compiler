package ast.statements;

import ast.expressions.Expression;
import ast.expressions.Id;
import visitor.Visitor;

import java.util.List;

public class ProcedureInvocation extends AbstractStatement {

    private final Id procedureId;
    private final List<Expression> parameters;

    public ProcedureInvocation(int line, int column, Id procedureId, List<Expression> parameters) {
        super(line, column);
        this.procedureId = procedureId;
        this.parameters = parameters;
    }

    public Id getProcedureId() {
        return procedureId;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        String paramString = String.join(", ", parameters.stream().map(p -> p.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
            "ProcedureInvocation (%d, %d):%n\t" +
                "procedureId: %s%n\t" +
                "parameters: %s",
            getLine(),
            getColumn(),
            procedureId,
            paramString
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProcedureInvocation that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.procedureId.equals(that.procedureId)) return false;
        if (this.parameters.size() != that.parameters.size()) return false;
        for (int i = 0; i < this.parameters.size(); i++) {
            if (!this.parameters.get(i).equals(that.parameters.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = procedureId.hashCode();
        for (Expression param : parameters) {
            result = 31 * result + param.hashCode();
        }
        result = 31 * result + getLine();
        result = 31 * result + getColumn();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
