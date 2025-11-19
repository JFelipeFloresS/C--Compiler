package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

import static utils.TypeMismatchUtils.getTypeMismatchError;

public class IntType extends AbstractType {
    public IntType(int line, int column) {
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
        if (that instanceof IntType)
            return this;

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node, true);
        }

        return new ErrorType(String.format("Cannot perform arithmetic operation between %s and %s", this, that), node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof IntType)
            return this;

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node);
        }

        return new ErrorType(String.format("Cannot perform assignment operation between %s and %s", this, that), node);
    }

    @Override
    public Type cast(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof IntType || that instanceof DoubleType || that instanceof CharType)
            return that;
        return new ErrorType(String.format("Cannot perform cast operation between %s and %s", this, that), node);
    }

    @Override
    public Type relational(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;

        if (that instanceof IntType)
            return new IntType(this.getLine(), this.getColumn());

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node, true);
        }

        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;

        if (that instanceof IntType)
            return new IntType(this.getLine(), this.getColumn());

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node, true);
        }

        return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }
}
