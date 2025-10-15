package ast.expressions;

public class LogicalNot extends AbstractExpression {

    private final Expression expression;
    public Expression getExpression() {
        return expression;
    }

    public LogicalNot(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return String.format(
                "LogicalNot:%s" +
                "expression: %s",
                "\n\t",
                expression.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof LogicalNot that)) return false;

        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (! this.expression.equals(that.expression)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + this.expression.hashCode();
        return result;
    }
}
