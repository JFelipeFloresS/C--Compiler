package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.statements.Return;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private final SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VariableDefinition varDef, Void param) {
        symbolTable.insert(varDef);
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void param) {
        if (!symbolTable.insert(funcDef)) {
            funcDef.getNames().getFirst().setType(new ErrorType("Error: Function \"" + funcDef.getNames().getFirst().getName() + "\" already defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), funcDef.getNames().getFirst()));
            return null;
        }

        symbolTable.set(funcDef);
        funcDef.getType().accept(this, param); // visits params
        for (var varDef : funcDef.getLocalVars()) {
            varDef.accept(this, param);
        }
        for (var stmt : funcDef.getStmtsBlock()) {
            stmt.accept(this, param);
        }

        symbolTable.reset();
        return null;
    }

    @Override
    public Void visit(Id id, Void param) {
        id.setScope(symbolTable.getCurrentScope());
        Definition varDef = symbolTable.find(id.getName());
        if (varDef == null) {
            id.setType(new ErrorType("Error: Variable \"" + id.getName() + "\" not defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), id));
        } else {
            id.setScope(symbolTable.getCurrentScope());
            id.setDefinition(varDef);
            id.setType(varDef.getType());
        }
        return null;
    }

    @Override
    public Void visit(Return _return, Void param) {
        _return.getExpression().accept(this, null);
        _return.setFuncDef(symbolTable.getFunctionDefinitionByScope(symbolTable.getCurrentScope()));

        return null;
    }

    @Override
    public Void visit(Program program, Void param) {
        super.visit(program, param);
        symbolTable.reset();
        return null;
    }

}
