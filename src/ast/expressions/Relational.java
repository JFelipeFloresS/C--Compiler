package ast.expressions;

public class Relational extends AbstractBinaryExpression {

    public Relational(int line, int col, Expression left, String operator, Expression right) {
        super(line, col, left, operator, right);
    }

}
