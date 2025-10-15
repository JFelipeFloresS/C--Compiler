package ast.expressions;

public class Logical extends AbstractBinaryExpression {
    public Logical(int line, int col, Expression left, String operator, Expression right) {
        super(line, col, left, operator, right);
    }
}
