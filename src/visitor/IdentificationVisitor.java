package visitor;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.types.ErrorType;
import error_handler.ErrorHandler;

import java.util.HashMap;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    HashMap<String, Definition> globalDefinitions = new HashMap<>();

    @Override
    public Void visit(VariableDefinition varDef, Void param) {
        Id newId = varDef.getNames().stream().filter(name -> globalDefinitions.containsKey(name.getName())).findFirst().orElse(null);
        if (newId != null) {
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Variable " + newId + " already defined.", newId));
        } else {
            varDef.getNames().forEach(name -> globalDefinitions.put(name.getName(), varDef));
        }
        return null;
    }


    @Override
    public Void visit(FunctionDefinition funcDef, Void param) {
        Id newId = funcDef.getNames().getFirst();
        if (globalDefinitions.containsKey(newId.getName())) {
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Function " + newId + " already defined.", newId));
        } else {
            globalDefinitions.put(newId.getName(), funcDef);
        }

        return null;
    }

    @Override
    public Void visit(Id id, Void param) {
        Definition varDef = globalDefinitions.get(id.getName());
        if (varDef == null) {
            ErrorHandler.getErrorHandler().addError(new ErrorType("Error: Variable " + id.getName() + " not defined.", id));
        } else {
            id.setDefinition(varDef);
        }
        return null;
    }
}
