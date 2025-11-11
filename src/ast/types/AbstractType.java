package ast.types;

import ast.locatable.AbstractLocatable;
import ast.locatable.Locatable;

import java.util.Objects;

public abstract class AbstractType extends AbstractLocatable implements Type {

    protected Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    protected AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type that, ast.locatable.Locatable node) {
        return new ErrorType("No arithmetic operation defined between " + this + " and " + that, node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        return new ErrorType("No assignment operation defined between " + this + " and " + that, node);
    }

    @Override
    public Type cast(Type that, ast.locatable.Locatable node) {
        return new ErrorType("No cast operation defined between " + this + " and " + that, node);
    }

    @Override
    public Type relational(Type that, ast.locatable.Locatable node) {
        return new ErrorType("No relational operation defined between " + this + " and " + that, node);
    }

    @Override
    public Type logical(Type that, ast.locatable.Locatable node) {
        return new ErrorType("No logical operation defined between " + this + " and " + that, node);
    }

    @Override
    public Type squareBrackets(Type type) {
        return new ErrorType("Type " + this + " is not subscriptable", this);
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d)",
            this.getClass().getSimpleName(),
            this.getLine(),
            this.getColumn());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractType that)) {
            System.out.println(this.getClass().getSimpleName() + " compared with different class: " + o.getClass().getSimpleName());
            return false;
        }

        if (this.getLine() != that.getLine()) {
            System.out.println(this.getClass().getSimpleName() + " line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }

        if (this.getColumn() != that.getColumn()) {
            System.out.println(this.getClass().getSimpleName() + " column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Integer.hashCode(getLine()),
            Integer.hashCode(getColumn()));
    }
}
