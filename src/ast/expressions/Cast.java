package ast.expressions;

import ast.types.Type;

public class Cast extends AbstractExpression {

    private final Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.setType(type);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format(
                "Cast:%s" +
                "type: %s%s" +
                "expression: %s",
                "\n\t",
                this.getType().toString(), "\n\t",
                expression.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cast that)) return false;
        return
            this.getLine() == that.getLine() &&
            this.getColumn() == that.getColumn() &&
            this.getType().equals(that.getType()) &&
            this.expression.equals(that.expression);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + this.getType().hashCode();
        result = 31 * result + this.expression.hashCode();
        return result;
    }
}
