package ast.types;

import ast.expressions.Expression;
import ast.locatable.Locatable;

public interface Type extends Locatable {
    Expression getSize();
}
