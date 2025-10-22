package ast.expressions;

import visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression {

    private final Id functionId;
    private final List<Expression> parameters;

    public FunctionInvocation(int line, int column, Id functionId, List<Expression> parameters) {
        super(line, column);
        this.functionId = functionId;
        this.parameters = parameters;
    }

    public Id getFunctionId() {
        return functionId;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        String params = String.join(", ", parameters.stream().map(expression -> expression.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
                "FunctionInvocation:%s" +
                "functionId: %s%s" +
                "params: %s",
                "\n\t",
            functionId, "\n\t",
                params
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FunctionInvocation that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.functionId.equals(that.functionId)) return false;
        if (this.parameters.size() != that.parameters.size()) return false;
        for (int i = 0; i < this.parameters.size(); i++) {
            if (!this.parameters.get(i).equals(that.parameters.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + this.functionId.hashCode();
        for (Expression param : this.parameters) {
            result = 31 * result + param.hashCode();
        }
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
