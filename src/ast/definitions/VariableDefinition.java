package ast.definitions;

import ast.types.Type;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;

public class VariableDefinition extends AbstractDefinition {

    private final List<String> names;

    public VariableDefinition(int line, int col, Type type, List<String> names) {
        super(line, col, type);
        this.names = names;
    }

    public List<String> getNames() {
        return this.names;
    }

    @Override
    public String toString() {
        String namesStr = String.join(", ", this.getNames());
        return String.format(
                "VariableDefinition (%d, %d):%n\t" +
                "type: %s%n\t" +
                "names: %s",
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

        if (!Objects.deepEquals(this.names, that.names)) {
          System.out.println("VariableDefinition names differ: " +
              String.join(", ", this.names) + " != " +
              String.join(", ", that.names));
          return false;
        }

        if (!this.getType().equals(that.getType())) {
          System.out.println("VariableDefinition types differ: " + this.getType() + " != " + that.getType());
          return false;
        }

        return  true;
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
