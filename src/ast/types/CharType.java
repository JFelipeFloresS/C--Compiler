package ast.types;

import ast.expressions.Expression;

public class CharType extends AbstractType {
    public CharType(int line, int column, Expression size) {
        super(line, column, size);
    }
}
