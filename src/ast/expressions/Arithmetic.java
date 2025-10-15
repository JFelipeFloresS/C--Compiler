package ast.expressions;

public class Arithmetic extends AbstractBinaryExpression {

    public Arithmetic(int line, int col, Expression left, String operator, Expression right) {
        super(line, col, left, operator, right);
    }

}
