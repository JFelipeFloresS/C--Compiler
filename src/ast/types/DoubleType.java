package ast.types;

import ast.expressions.Expression;

public class DoubleType extends AbstractType {
    public DoubleType(int line, int column, Expression size) {
        super(line, column, size);
    }
}
