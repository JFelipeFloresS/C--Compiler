package ast.statements;

import ast.locatable.AbstractLocatable;
import ast.types.Type;

public abstract class AbstractStatement extends AbstractLocatable implements Statement {

    protected Type type;

    protected AbstractStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}
