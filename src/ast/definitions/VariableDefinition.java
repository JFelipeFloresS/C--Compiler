package ast.definitions;

import ast.expressions.Id;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;

public class VariableDefinition extends AbstractDefinition {

    public VariableDefinition(int line, int col, Type type, List<Id> names) {
        super(line, col, type, names);
    }

    @Override
    public String toString() {
        String namesStr = String.join(", ", this.getNames().stream().map(Id::toString).toArray(String[]::new));
        return String.format(
            "VariableDefinition (%d, %d): %s \"%s\"",
            this.getLine(),
            this.getColumn(),
            this.getType().toString(),
            namesStr
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableDefinition that)) return false;

        if (this.getLine() != that.getLine()) {
            System.out.println("VariableDefinition line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }

        if (this.getColumn() != that.getColumn()) {
            System.out.println("VariableDefinition column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }

        if (this.names.size() != that.names.size()) {
            System.out.println("VariableDefinition names differ in size " + this.names.size() + " != " + that.names.size());
            return false;
        }

        for (int i = 0; i < this.names.size(); i++) {
            if (!Objects.deepEquals(this.names.get(i), that.names.get(i))) {
                System.out.println("VariableDefinition names differ at index " + i + ": " + this.names.get(i) + " != " + that.names.get(i));
                return false;
            }
        }

        if (!this.getType().equals(that.getType())) {
            System.out.println("VariableDefinition types differ: " + this.getType() + " != " + that.getType());
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + names.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
