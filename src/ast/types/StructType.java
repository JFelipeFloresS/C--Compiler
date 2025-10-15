package ast.types;

import ast.expressions.Expression;

public class StructType extends AbstractType {
    public StructType(int line, int column, Expression size) {
        super(line, column, size);
    }
}
