package ast.expressions;

import visitor.Visitor;

public class StructAccess extends AbstractExpression {

    private final Expression structExpression;
    private final String fieldName;

    public StructAccess(int line, int column, Expression structExpression, String fieldName) {
        super(line, column);
        this.structExpression = structExpression;
        this.fieldName = fieldName;
    }

    public Expression getStructExpression() {
        return structExpression;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return String.format(
                "StructAccess:%s" +
                "struct: %s%s" +
                "fieldName: %s",
                "\n\t",
                structExpression.getClass().getSimpleName(), "\n\t",
                fieldName
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StructAccess that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.structExpression.equals(that.structExpression)) return false;
        return this.fieldName.equals(that.fieldName);
    }

    @Override
    public int hashCode() {
        int result = structExpression.hashCode();
        result = 31 * result + fieldName.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
