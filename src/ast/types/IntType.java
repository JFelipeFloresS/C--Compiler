package ast.types;

import ast.expressions.Expression;

public class IntType extends AbstractType {
    public IntType(int line, int column, Expression size) {
        super(line, column, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntType that)) return false;
        return this.getLine() == that.getLine() &&
                this.getColumn() == that.getColumn() &&
                (this.getSize() == null ? that.getSize() == null : this.getSize().equals(that.getSize()));
    }

    @Override
    public int hashCode() {
        return super.hashCode()
                + 31 * "IntType".hashCode()
                + 31 * (getSize() != null ? getSize().hashCode() : 0);
    }
}
