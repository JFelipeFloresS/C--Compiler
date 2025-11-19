package ast.types;

import ast.locatable.Locatable;

public interface Type extends Locatable {

    Type getType();

    void setType(Type type);

    Type arithmetic(Type that, Locatable node);

    Type assignment(Type that, Locatable node);

    Type cast(Type that, Locatable node);

    Type relational(Type that, Locatable node);

    Type logical(Type that, Locatable node);

    Type squareBrackets(Type type);

    boolean isBuiltInType();
}
