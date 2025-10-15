package ast.definitions;

import ast.types.Type;

import java.util.List;

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
                "VariableDefinition:%s" +
                "type: %s%s" +
                "names: %s",
                "\n\t",
                this.getType().toString(), "\n\t",
                namesStr
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableDefinition that)) return false;

        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;

        boolean areNamesEqual = this.getNames().size() == that.getNames().size();
        if (areNamesEqual) {
            for (int i = 0; i < this.getNames().size(); i++) {
                if (!this.getNames().get(i).equals(((VariableDefinition) o).getNames().get(i))) {
                    areNamesEqual = false;
                    break;
                }
            }
        }
        if (!areNamesEqual) return false;

        if (!this.getType().equals(that.getType())) return false;
        return this.getNames().equals(that.getNames());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + names.hashCode();
        return result;
    }
}
