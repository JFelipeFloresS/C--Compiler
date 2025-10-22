package ast.types;

import ast.expressions.Expression;
import ast.locatable.Locatable;
import visitor.Visitor;

public class StructType extends AbstractType {

    private final String name;
    public String getName() {
        return name;
    }

    public StructType(int line, int column, Expression size, String name) {
        super(line, column, size);
        this.name = name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type that, Locatable node) {
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
        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
    }
}
