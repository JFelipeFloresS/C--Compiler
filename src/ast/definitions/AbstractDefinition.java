package ast.definitions;

import ast.expressions.Id;
import ast.locatable.AbstractLocatable;
import ast.types.Type;

import java.util.List;

public abstract class AbstractDefinition extends AbstractLocatable implements Definition {

	protected final Type type;
	protected final List<Id> names;
	protected int scope = -1;

	protected AbstractDefinition(int line, int column, Type type, List<Id> names) {
		super(line, column);
		this.type = type;
		this.names = names;
	}

	public Type getType() {
		return type;
	}

	public List<Id> getNames() {
		return names;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract int hashCode();
}
