package ast.types;

import visitor.Visitor;

public class ArrayType extends AbstractType {

    private final Type elementType;
    private final int size;

    public ArrayType(int line, int column, Type elementType, int size) {
        super(line, column);
        this.elementType = elementType;
        this.size = size;
    }

    public Type getElementType() {
        return elementType;
    }

    public int getSize() {
        return size;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        this.elementType.accept(visitor, param);
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type type) {
        if (type instanceof ErrorType) {
            return type;
        }

        if (type instanceof IntType) {
            return this.getElementType();
        }

        return new ErrorType("The type of the index (" + type + ") must be an integer", this);
    }

    @Override
    public String toString() {
        return String.format("ArrayType(%d, %d) %s[%d]",
            getLine(),
            getColumn(),
            getElementType(),
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

        if (!this.getElementType().equals(that.getElementType())) {
            System.out.println("ArrayType built-in types differ: " + this.getElementType() + " != " + that.getElementType());
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getLine());
        result = 31 * result + Integer.hashCode(getColumn());
        result = 31 * result + getElementType().hashCode();
        result = 31 * result + Integer.hashCode(size);
        return result;
    }
}
