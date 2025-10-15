package ast.definitions;

import ast.statements.AbstractStatement;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractStatement implements Definition {

    private final Type type;

    protected AbstractDefinition(int line, int column, Type type) {
        super(line, column);
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }
}
