package ast.definitions;

import ast.types.Type;
import visitor.Visitor;

import java.util.List;

public class StructDefinition extends VariableDefinition {

    private final List<VariableDefinition> definitions;
    public List<VariableDefinition> getDefinitions() {
        return definitions;
    }

    public StructDefinition(int line, int col, Type type, List<String> name, List<VariableDefinition> definitions) {
        super(line, col, type, name);
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        String names = String.join(", ", this.getNames());
        return String.format(
                "StructDefinition (%d, %d):%n\t" +
                "variable definitions count: %d%n\t" +
                "type: %s%n\t" +
                "names: %s",
                this.getLine(),
                this.getColumn(),
                this.getDefinitions().size(),
                this.getType().toString(),
                names
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StructDefinition that)) return false;
        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;
        if (!this.getType().equals(that.getType())) return false;
        if (this.getNames().size() != that.getNames().size()) return false;
        for (int i = 0; i < this.getNames().size(); i++) {
            if (!this.getNames().get(i).equals(that.getNames().get(i))) return false;
        }
        if (this.getDefinitions().size() != that.getDefinitions().size()) return false;
        for (int i = 0; i < this.getDefinitions().size(); i++) {
            if (!this.getDefinitions().get(i).equals(that.getDefinitions().get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        for (String name : getNames()) {
            result = 31 * result + name.hashCode();
        }
        for (VariableDefinition def : definitions) {
            result = 31 * result + def.hashCode();
        }
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
          return visitor.visit(this, param);
      }

}
