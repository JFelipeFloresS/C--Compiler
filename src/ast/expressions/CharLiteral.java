package ast.expressions;

import visitor.Visitor;

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
        if (!(o instanceof CharLiteral that)) {
            System.out.println("Not Instance of CharLiteral");
            return false;
        }

        if (this.getLine() != that.getLine()) {
            System.out.println("CharLiteral Line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }

        if (this.getColumn() != that.getColumn()) {
            System.out.println("CharLiteral Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }

        if (this.value != that.value) {
            System.out.println("CharLiteral values differ: " + this.value + " != " + that.value);
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getLine());
        result = 31 * result + Integer.hashCode(getColumn());
        result = 31 * result + Character.hashCode(value);
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
