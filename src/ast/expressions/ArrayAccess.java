package ast.expressions;

public class ArrayAccess extends AbstractExpression {

    private final Expression array;
    private final Expression index;

    public ArrayAccess(int line, int column, Expression array, Expression index) {
        super(line, column);
        this.array = array;
        this.index = index;
    }

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return String.format(
                "ArrayAccess:%s" +
                "array: %s%s" +
                "index: %s",
                "\n\t",
                array.getClass().getSimpleName(), "\n\t",
                index.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayAccess that)) return false;

        return getLine() == that.getLine() &&
            getColumn() == that.getColumn() &&
            array.equals(that.array) &&
            index.equals(that.index);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getLine());
        result = 31 * result + Integer.hashCode(getColumn());
        result = 31 * result + array.hashCode();
        result = 31 * result + index.hashCode();
        return result;
    }
}
