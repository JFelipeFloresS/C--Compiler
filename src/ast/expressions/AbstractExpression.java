package ast.expressions;

import ast.locatable.AbstractLocatable;
import ast.types.Type;

public abstract class AbstractExpression extends AbstractLocatable implements Expression {

    protected AbstractExpression(int line, int column) {
        super(line, column);
    }

    private Type type;

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

}
