package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

import static utils.TypeMismatchUtils.getTypeMismatchError;

public class CharType extends AbstractType {
    public CharType(int line, int column) {
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

        if (that instanceof CharType) {
            return new IntType(this.getLine(), this.getColumn());
        }

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node, true);
        }

        return new ErrorType(String.format("Cannot perform arithmetic operation between %s and %s", this, that), node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof CharType) {
            return that;
        }

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node);
        }

        return new ErrorType(String.format("Cannot perform assignment operation between %s and %s", this, that), node);
    }

    @Override
    public Type cast(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof CharType || that instanceof IntType || that instanceof DoubleType) {
            return that;
        }
        return new ErrorType(String.format("Cannot perform cast operation between %s and %s", this, that), node);
    }

    @Override
    public Type relational(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;

        if (that instanceof CharType) {
            return new IntType(this.getLine(), this.getColumn());
        }

        if (that.isBuiltInType()) {
            return getTypeMismatchError(this, that, node, true);
        }

        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;

        if (that instanceof CharType) {
            return new IntType(this.getLine(), this.getColumn());
        }

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
