package ast.statements;

import ast.locatable.AbstractLocatable;

public abstract class AbstractStatement extends AbstractLocatable implements Statement {
    protected AbstractStatement(int line, int column) {
        super(line, column);
    }
}
