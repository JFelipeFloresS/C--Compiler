package ast.expressions;

import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression {

    private final double value;
    public double getValue() {
        return value;
    }

    public DoubleLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "DoubleLiteral:%s" +
                "value: %f",
                "\n\t",
                value
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DoubleLiteral that)) return false;

        return
            this.getLine() == that.getLine() &&
            this.getColumn() == that.getColumn() &&
            (
                (this.getType() != null && this.getType().equals(that.getType())) ||
                (this.getType() == null && that.getType() == null)
            ) &&
            this.getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        int result = 17;
      result = 31 * result + Double.hashCode(this.getValue());
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + (this.getType() != null ? this.getType().hashCode() : 0);
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
