package ast.locatable;

public abstract class AbstractLocatable implements Locatable {

    private final int line;
    private final int column;

    protected AbstractLocatable(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
