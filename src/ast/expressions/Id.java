package ast.expressions;

import ast.definitions.Definition;
import visitor.Visitor;

public class Id extends AbstractExpression {

    private final String name;
    public String getName() {
        return this.name;
    }

    public Id(int line, int col, String name) {
        super(line, col);
        this.name = name;
    }

    private Definition definition;
    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return String.format(
                "Id:%s" +
                "value: %s",
                "\n\t",
                this.name
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Id that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
