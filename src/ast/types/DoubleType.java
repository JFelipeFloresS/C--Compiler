package ast.types;

import ast.expressions.Expression;
import ast.locatable.Locatable;
import visitor.Visitor;

public class DoubleType extends AbstractType {
    public DoubleType(int line, int column, Expression size) {
        super(line, column, size);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof IntType || that instanceof DoubleType || that instanceof CharType)
            return this;
        return new ErrorType(String.format("Cannot perform arithmetic operation between %s and %s", this, that), node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof DoubleType || that instanceof IntType || that instanceof CharType)
            return this;
        return new ErrorType(String.format("Cannot perform assignment operation between %s and %s", this, that), node);
    }

    @Override
    public Type cast(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        if (that instanceof DoubleType || that instanceof IntType || that instanceof CharType)
            return that;
        return new ErrorType(String.format("Cannot perform cast operation between %s and %s", this, that), node);
    }

    @Override
    public Type relational(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
    }
}
