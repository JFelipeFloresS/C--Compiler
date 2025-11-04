package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

public class ArrayType extends AbstractType {

  private final Type builtInType;
  public Type getBuiltInType() {
    return builtInType;
  }
  private final int size;
  public int getSize() {
    return size;
  }

  public ArrayType(int line, int column, Type builtInType, int size) {
    super(line, column);
    this.builtInType = builtInType;
    this.size = size;
  }

  @Override
  public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
    this.builtInType.accept(visitor, param);
    return visitor.visit(this, param);
  }

  @Override
  public Type arithmetic(Type that, Locatable node) {
    if (that instanceof ErrorType) {
      return that;
    }

    if (this.getBuiltInType() instanceof VoidType ||
        this.getBuiltInType() instanceof StructType ||
        (that instanceof ArrayType thatArrayType &&
            (thatArrayType.getBuiltInType() instanceof StructType ||
              thatArrayType.getBuiltInType() instanceof VoidType))) {
      return new ErrorType("Incompatible types for arithmetic operation", node);
    }

    if (that instanceof ArrayType thatArrayType && this.getSize() == thatArrayType.getSize()) {
      return this;
    }

    return new ErrorType("Incompatible types for arithmetic operation", node);
  }

  @Override
  public Type assignment(Type that, Locatable node) {
    if (that instanceof ErrorType) {
      return that;
    }

    return new ErrorType("Incompatible types for assignment operation", node);
  }

  @Override
  public Type cast(Type that, Locatable node) {
    if (that instanceof ErrorType) {
      return that;
    }

    return new ErrorType("Incompatible types for cast operation", node);
  }

  @Override
  public Type relational(Type that, Locatable node) {
    if (that instanceof ErrorType) {
      return that;
    }

    return new ErrorType("Incompatible types for relational operation", node);
  }

  @Override
  public Type logical(Type that, Locatable node) {
    if (that instanceof ErrorType) {
      return that;
    }

    return new ErrorType("Incompatible types for logical operation", node);
  }

  @Override
  public String toString() {
    return String.format("ArrayType(%d, %d) %s[%d]",
        getLine(),
        getColumn(),
        getBuiltInType(),
        getSize());
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ArrayType that)) {
      return false;
    }

    if (this == that) {
      return true;
    }

    if (this.getLine() != that.getLine()) {
      System.out.println("ArrayType line numbers differ: " + this.getLine() + " != " + that.getLine());
      return false;
    }

    if (this.getColumn() != that.getColumn()) {
      System.out.println("ArrayType column numbers differ: " + this.getColumn() + " != " + that.getColumn());
      return false;
    }

    if (this.getSize() != that.getSize()) {
      System.out.println("ArrayType sizes differ: " + this.getSize() + " != " + that.getSize());
      return false;
    }

    if (!this.getBuiltInType().equals(that.getBuiltInType())) {
      System.out.println("ArrayType built-in types differ: " + this.getBuiltInType() + " != " + that.getBuiltInType());
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(getLine());
    result = 31 * result + Integer.hashCode(getColumn());
    result = 31 * result + getBuiltInType().hashCode();
    result = 31 * result + Integer.hashCode(size);
    return result;
  }
}
