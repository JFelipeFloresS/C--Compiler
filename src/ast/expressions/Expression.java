package ast.expressions;

import ast.locatable.Locatable;
import ast.types.Type;

public interface Expression extends Locatable {

	Type getType();

	void setType(Type type);

}
