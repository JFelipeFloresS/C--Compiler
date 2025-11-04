package ast.definitions;

import ast.expressions.Id;
import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;

public class FunctionDefinition extends AbstractDefinition implements Definition {

    private final Id name;
    private final List<VariableDefinition> localVars;
    private final List<Statement> stmtsBlock;

    public FunctionDefinition(int line, int col, Type type, Id name, List<VariableDefinition> localVars, List<Statement> stmtsBlock) {
        super(line, col, type);
        this.name = name;
        this.localVars = localVars;
        this.stmtsBlock = stmtsBlock;
    }

    public Id getName() {
        return this.name;
    }

    public List<VariableDefinition> getLocalVars() {
        return this.localVars;
    }

    public List<Statement> getStmtsBlock() {
        return this.stmtsBlock;
    }

    @Override
    public String toString() {
        return String.format(
                "FunctionDefinition (%d, %d): %s \"%s\"%n\t" +
                "local variables count: %d%n\t" +
                "body stmts count: %d",
                this.getLine(),
                this.getColumn(),
                this.getType().toString(),
                this.getName(),
                this.getLocalVars() != null ? this.getLocalVars().size() : 0,
                this.getStmtsBlock() != null ? this.getStmtsBlock().size() : 0
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FunctionDefinition that)) {
          System.out.println("Object is not a FunctionDefinition " + o);
          return false;
        }

        if (this.getLine() != that.getLine()) {
          System.out.println("FunctionDefinition line numbers differ: " + this.getLine() + " != " + that.getLine());
          return false;
        }

        if (this.getColumn() != that.getColumn()) {
          System.out.println("FunctionDefinition column numbers differ: " + this.getColumn() + " != " + that.getColumn());
          return false;
        }

        if (!this.getType().equals(that.getType())) {
          System.out.println("FunctionDefinition types differ: " + this.getType() + " != " + that.getType());
          return false;
        }

        if (!this.name.equals(that.name)) {
          System.out.println("FunctionDefinition names differ: " + this.name + " != " + that.name);
          return false;
        }

        if (!Objects.deepEquals(this.localVars, that.localVars)) {
          System.out.println("FunctionDefinition localVars differ: " +
              String.join(", ", this.localVars.stream().map(VariableDefinition::toString).toArray(String[]::new)) + " != " +
              String.join(", ", that.localVars.stream().map(VariableDefinition::toString).toArray(String[]::new)));
          return false;
        }

        if (!Objects.deepEquals(this.stmtsBlock, that.stmtsBlock)) {
          System.out.println("FunctionDefinition stmtsBlock differ: " +
              String.join(", ", this.stmtsBlock.stream().map(Statement::toString).toArray(String[]::new)) + " != " +
              String.join(", ", that.stmtsBlock.stream().map(Statement::toString).toArray(String[]::new)));
          return false;
        }

        return  true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + stmtsBlock.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
