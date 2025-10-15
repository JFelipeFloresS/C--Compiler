package ast.expressions;

public class CharLiteral extends AbstractExpression {

    private final char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format(
                "CharLiteral:%s" +
                "value: %s",
                "\n\t",
                value
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CharLiteral that)) return false;
        return
            this.getLine() == that.getLine() &&
            this.getColumn() == that.getColumn() &&
            this.getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return (int) value + getLine() + getColumn();
    }
}
