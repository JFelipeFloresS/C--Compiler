package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

public class ErrorType extends AbstractType {

    private final String message;

    public ErrorType(String message, Locatable node) {
        super(node.getLine(), node.getColumn());
        this.message = message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type that, Locatable node) {
        return this;
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        return this;
    }

    @Override
    public Type cast(Type that, Locatable node) {
        return this;
    }

    @Override
    public Type relational(Type that, Locatable node) {
        return this;
    }

    @Override
    public Type logical(Type that, Locatable node) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type) {
        return this;
    }

    @Override
    public String toString() {
        return String.format("Error (%d, %d): %s", getLine(), getColumn(), message);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ErrorType;
    }

    @Override
    public int hashCode() {
        return 42; // All ErrorType instances are considered equal
    }
}
