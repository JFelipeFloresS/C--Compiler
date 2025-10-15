package ast.expressions;

import ast.locatable.Locatable;
import ast.types.Type;

public interface Expression extends Locatable {

    public Type getType();

    public void setType(Type type);

}
