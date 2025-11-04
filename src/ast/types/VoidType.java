package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

public class VoidType extends AbstractType {
    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform arithmetic operation between %s and %s", this, that), node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform assignment operation between %s and %s", this, that), node);
    }

    @Override
    public Type cast(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform cast operation between %s and %s", this, that), node);
    }

    @Override
    public Type relational(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
    }

    @Override
    public String toString() {
        return String.format("void (%d, %d)",
            this.getLine(),
            this.getColumn());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof VoidType that)) {
        return false;
      }

      if (this.getLine() != that.getLine()) {
        System.out.println("VoidType line number differ: " + this.getLine() + " != " + that.getLine());
        return false;
      }

      if (this.getColumn() != that.getColumn()) {
        System.out.println("VoidType column number differ: " + this.getColumn() + " != " + that.getColumn());
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 31 * getLine() + getColumn();
    }
}
