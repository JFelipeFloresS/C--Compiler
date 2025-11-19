package ast.statements;

import ast.locatable.Locatable;

public interface Statement extends Locatable {

	public int getScope();

	public void setScope(int scope);

}
