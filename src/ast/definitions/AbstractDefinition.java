package ast.definitions;

import ast.locatable.AbstractLocatable;
import ast.statements.AbstractStatement;
import ast.types.Type;
import visitor.Visitor;

public abstract class AbstractDefinition extends AbstractLocatable implements Definition {

    protected final Type type;
    public Type getType() {
      return type;
    }

    protected AbstractDefinition(int line, int column, Type type) {
        super(line, column);
        this.type = type;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);
}
