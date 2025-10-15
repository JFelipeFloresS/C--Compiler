package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition implements Definition {

    private final String name;
    private final List<VariableDefinition> params;
    private final List<Statement> body;

    public FunctionDefinition(int line, int col, Type type, String name, List<VariableDefinition> params, List<Statement> body) {
        super(line, col, type);
        this.name = name;
        this.params = params;
        this.body = body;
    }

    public String getName() {
        return this.name;
    }

    public List<Statement> getBody() {
        return this.body;
    }

    public List<VariableDefinition> getParams() {
        return params;
    }

    @Override
    public String toString() {
        String paramNames = String.join(", ", this.getParams().stream().map(varDef -> varDef.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
                "FunctionDefinition:%s" +
                "functionType: %s%s" +
                "name: %s%s" +
                "param: %s%s" +
                "body stmts count: %d",
                "\n\t",
                this.getType().toString(), "\n\t",
                this.getName(), "\n\t",
                paramNames, "\n\t",
                this.getBody().size()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FunctionDefinition that)) return false;

        boolean areParamsEqual = this.params.size() == that.params.size();
        if (areParamsEqual) {
            for (int i = 0; i < this.params.size(); i++) {
                if (!this.params.get(i).equals(that.params.get(i))) {
                    areParamsEqual = false;
                    break;
                }
            }
        }
        if (!areParamsEqual) return false;

        boolean isBodyEqual = this.body.size() == that.body.size();
        if (isBodyEqual) {
            for (int i = 0; i < this.body.size(); i++) {
                if (!this.body.get(i).equals(that.body.get(i))) {
                    isBodyEqual = false;
                    break;
                }
            }
        }
        if (!isBodyEqual) return false;

        return this.getLine() == that.getLine() &&
               this.getColumn() == that.getColumn() &&
               this.getType().equals(that.getType()) &&
               this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + params.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}
