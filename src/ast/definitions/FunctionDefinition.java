package ast.definitions;

import ast.expressions.Id;
import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition implements Definition {

    private final List<VariableDefinition> localVars;
    private final List<Statement> stmtsBlock;

    public FunctionDefinition(int line, int col, Type type, Id name, List<VariableDefinition> localVars, List<Statement> stmtsBlock) {
        super(line, col, type, List.of(name));
        this.localVars = localVars;
        this.stmtsBlock = stmtsBlock;
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
            this.getNames().getFirst().getName(),
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

        String thisName = this.getNames().getFirst().getName();
        String thatName = that.getNames().getFirst().getName();

        if (!thisName.equals(thatName)) {
            System.out.println("FunctionDefinition names differ: " + thisName + " != " + thatName);
            return false;
        }

        if (this.localVars.size() != that.localVars.size()) {
            System.out.println("FunctionDefinition localVars differ in size: " + this.localVars.size() + " != " + that.localVars.size());
            return false;
        }

        for (int i = 0; i < this.localVars.size(); i++) {
            if (!this.localVars.get(i).equals(that.localVars.get(i))) {
                System.out.println("FunctionDefinition localVars differ at index " + i + ": " +
                    this.localVars.get(i) + " != " + that.localVars.get(i));
                return false;
            }
        }

        if (this.stmtsBlock.size() != that.stmtsBlock.size()) {
            System.out.println("FunctionDefinition stmtsBlock differ in size: " + this.stmtsBlock.size() + " != " + that.stmtsBlock.size());
            return false;
        }

        for (int i = 0; i < this.stmtsBlock.size(); i++) {
            if (!this.stmtsBlock.get(i).equals(that.stmtsBlock.get(i))) {
                System.out.println("FunctionDefinition stmtsBlock differ at index " + i + ": " +
                    this.stmtsBlock.get(i) + " != " + that.stmtsBlock.get(i));
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getNames().hashCode();
        result = 31 * result + getLine();
        result = 31 * result + getColumn();
        result = 31 * result + localVars.hashCode();
        result = 31 * result + stmtsBlock.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
