package ast.statements;

import ast.expressions.Expression;

public class Return extends AbstractStatement {

    private final Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format(
                "Return:%s" +
                "expression: %s",
                "\n\t",
                expression.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Return other)) {
            return false;
        }
        return this.getLine() == other.getLine()
                && this.getColumn() == other.getColumn()
                && ((this.expression == null && other.expression == null)
                || (this.expression != null && this.expression.equals(other.expression)));
    }

    @Override
    public int hashCode() {
        return (expression == null) ? 0 : expression.hashCode();
    }
}
