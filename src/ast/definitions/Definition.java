package ast.definitions;

import ast.locatable.Locatable;
import ast.types.Type;

public interface Definition extends Locatable {

    public Type getType();

}
