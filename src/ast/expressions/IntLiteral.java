package ast.expressions;

import visitor.Visitor;

public class IntLiteral extends AbstractExpression {

    private final int value;
    public int getValue() {
        return this.value;
    }

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "IntLiteral:%s" +
                "value: %d",
                "\n\t",
                this.value
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntLiteral that)) return false;

        return this.getLine() == that.getLine() &&
                this.getColumn() == that.getColumn() &&
                this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
