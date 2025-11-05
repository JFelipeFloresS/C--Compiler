package ast.expressions;

import ast.definitions.Definition;
import visitor.Visitor;

public class Id extends AbstractExpression {

    private final String name;
    private int scope = -1;
    private Definition definition;

    public Id(int line, int col, String name) {
        super(line, col);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScope() {
        return this.scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return String.format(
            "Id: %s (%d, %d)",
            this.getName(),
            this.getLine(),
            this.getColumn()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Id that)) {
            System.out.println("Not Id instance type found " + o.getClass().getName());
            return false;
        }
        if (this.getLine() != that.getLine()) {
            System.out.println("Id line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }
        if (this.getColumn() != that.getColumn()) {
            System.out.println("Id column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }
        if (!this.getName().equals(that.getName())) {
            System.out.println("Id names differ: " + this.getName() + " != " + that.getName());
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLine();
        result = 31 * result + this.getColumn();
        result = 31 * result + this.getName().hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
