package ast.types;

import ast.locatable.AbstractLocatable;

import java.util.Objects;

public abstract class AbstractType extends AbstractLocatable implements Type {

    protected AbstractType(int line, int column) {
        super(line, column);
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
        if (! (o instanceof AbstractType that)) {
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
