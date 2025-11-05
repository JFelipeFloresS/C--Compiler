package ast.expressions;

import visitor.Visitor;

public class Arithmetic extends AbstractBinaryExpression {
 
    public Arithmetic(int line, int col, Expression left, String operator, Expression right) {
        super(line, col, left, operator, right);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
