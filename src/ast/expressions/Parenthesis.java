package ast.expressions;

public class Parenthesis extends AbstractExpression {

    private final Expression expression;

    public Parenthesis(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format(
                "Parenthesis:%s" +
                "expression: %s",
                "\n\t",
                expression.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Parenthesis that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
      return this.expression.equals(that.expression);
    }
}
