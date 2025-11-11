package visitor;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.types.ErrorType;
import error_handler.ErrorHandler;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private final SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VariableDefinition varDef, Void param) {
        varDef.setScope(symbolTable.getCurrentScope());
        if (!symbolTable.insert(varDef)) {
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Variable \"" + varDef.getNames().getFirst().getName() + "\" already defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), varDef.getNames().getFirst()));
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void param) {
        symbolTable.reset();

        if (!symbolTable.insert(funcDef)) {
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Function \"" + funcDef.getNames().getFirst().getName() + "\" already defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), funcDef.getNames().getFirst()));
            return null;
        }

        funcDef.setScope(symbolTable.getCurrentScope());
        symbolTable.set();

        funcDef.getType().accept(this, param); // visits params
        for (var varDef : funcDef.getLocalVars()) {
            varDef.setScope(symbolTable.getCurrentScope());
            varDef.accept(this, param);
        }
        for (var stmt : funcDef.getStmtsBlock()) {
            stmt.setScope(symbolTable.getCurrentScope());
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
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Variable \"" + id.getName() + "\" not defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), id));
        } else {
            id.setScope(symbolTable.getCurrentScope());
            id.setDefinition(varDef);
            id.setType(varDef.getType());
        }
        return null;
    }
}
