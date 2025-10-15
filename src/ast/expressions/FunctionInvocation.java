package ast.expressions;

import java.util.List;

public class FunctionInvocation extends AbstractExpression {

    private final String functionName;
    private final List<Expression> parameters;

    public FunctionInvocation(int line, int column, String functionName, List<Expression> parameters) {
        super(line, column);
        this.functionName = functionName;
        this.parameters = parameters;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        String params = String.join(", ", parameters.stream().map(expression -> expression.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
                "FunctionInvocation:%s" +
                "functionName: %s%s" +
                "params: %s",
                "\n\t",
                functionName, "\n\t",
                params
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FunctionInvocation that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.functionName.equals(that.functionName)) return false;
        if (this.parameters.size() != that.parameters.size()) return false;
        for (int i = 0; i < this.parameters.size(); i++) {
            if (!this.parameters.get(i).equals(that.parameters.get(i))) return false;
        }
        return true;
    }
}
