package ast.expressions;

public abstract class AbstractBinaryExpression extends AbstractExpression implements Expression {

    private final Expression left;
    private final Expression right;
    private final String operator;

    protected AbstractBinaryExpression(int line, int col, Expression left, String operator, Expression right) {
        super(line, col);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return String.format(
                "%s:%s" +
                "left expression: %s%s" +
                "operator: %s%s" +
                "right expression: %s",
                this.getClass(), "\n\t",
                left.getClass().getSimpleName(), "\n\t",
                operator, "\n\t",
                right.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractBinaryExpression that)) return false;

        return
            this.getLine() == that.getLine() &&
            this.getColumn() == that.getColumn() &&
            (
                (this.getType() != null && this.getType().equals(that.getType())) ||
                (this.getType() == null && that.getType() == null)
            ) &&
            this.getLeft().equals(that.getLeft()) &&
            this.getRight().equals(that.getRight()) &&
            this.getOperator().equals(that.getOperator());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getLine();
        result = 31 * result + getColumn();
        result = 31 * result + getType().hashCode();
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }
}
