package ast.definitions;

import ast.expressions.Id;
import ast.locatable.Locatable;
import ast.types.Type;

import java.util.List;

public interface Definition extends Locatable {

	Type getType();

	List<Id> getNames();

	int getScope();

	void setScope(int scope);

}
