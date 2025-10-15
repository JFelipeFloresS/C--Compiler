package ast.expressions;

public class ArrayIndex extends AbstractExpression {

    private final Expression nextIndex;
    private final Expression index;

    public ArrayIndex(int line, int col, Expression index, Expression nextIndex) {
        super(line, col);
        this.index = index;
        this.nextIndex = nextIndex;
    }

    public Expression getNextIndex() {
        return this.nextIndex;
    }

    public Expression getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        return String.format(
                "ArrayIndex:%s" +
                "index: %s%s" +
                "nextIndex: %s",
                "\n\t",
                index.getClass().getSimpleName(), "\n\t",
                nextIndex != null ? String.format(" nextIndex(%s)", nextIndex.getClass().getSimpleName()) : "none"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIndex that)) return false;
        if (getLine() != that.getLine() || getColumn() != that.getColumn()) return false;
        if (!index.equals(that.index)) return false;
        return (nextIndex == null && that.nextIndex == null) || (nextIndex != null && nextIndex.equals(that.nextIndex));
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getLine()) ^
            Integer.hashCode(getColumn()) ^
            index.hashCode() ^
            (nextIndex != null ? nextIndex.hashCode() : 0);
    }
}
