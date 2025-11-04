package ast.expressions;

import visitor.Visitor;

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
        if (!(o instanceof AbstractBinaryExpression that)) {
          System.out.println("Not an AbstractBinaryExpression instance");
          return false;
        }

        if (this.getLine() != that.getLine()) {
          System.out.println("AbstractBinaryExpression Line numbers differ: " + this.getLine() + " != " + that.getLine());
          return false;
        }

        if (this.getColumn() != that.getColumn()) {
          System.out.println("AbstractBinaryExpression Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
          return false;
        }

        if ( (this.getType() != null && that.getType() == null) || (this.getType() == null && that.getType() != null) ) {
          System.out.println("AbstractBinaryExpression Types differ: " + this.getType() + " != " + that.getType());
          return false;
        }

        if (this.getType() != null && !this.getType().equals(that.getType())) {
          System.out.println("AbstractBinaryExpression Types differ: " + this.getType() + " != " + that.getType());
          return false;
        }

        if (!this.getLeft().equals(that.getLeft())) {
          System.out.println("AbstractBinaryExpression Left expressions differ: " + this.getLeft() + " != " + that.getLeft());
          return false;
        }

        if (!this.getRight().equals(that.getRight())) {
          System.out.println("AbstractBinaryExpression Right expressions differ: " + this.getRight() + " != " + that.getRight());
          return false;
        }

        if (!this.getOperator().equals(that.getOperator())) {
          System.out.println("AbstractBinaryExpression Operators differ: " + this.getOperator() + " != " + that.getOperator());
          return false;
        }

        return true;
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
