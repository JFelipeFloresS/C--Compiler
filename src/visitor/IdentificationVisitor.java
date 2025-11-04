package visitor;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;

import java.util.HashMap;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

  HashMap<String, Definition> stmts = new HashMap<>();

  @Override
  public Void visit(VariableDefinition varDef, Void param) {
    Id newId = varDef.getNames().stream().filter(name -> stmts.containsKey(name.getName())).findFirst().orElse(null);
    if (newId != null) {
      System.out.println("Error: Variable " + newId.toString() + " already defined.");
    } else {
      varDef.getNames().forEach(name -> stmts.put(name.getName(), varDef));
    }
    return null;
  }

  @Override
  public Void visit(FunctionDefinition funcDef, Void param) {
    Id newId = funcDef.getName();
    if (stmts.containsKey(newId.getName())) {
      System.out.println("Error: Function " + newId.toString() + " already defined.");
    } else {
      stmts.put(newId.getName(), funcDef);
    }
    return null;
  }

  @Override
  public Void visit(Id id, Void param) {
    Definition varDef = stmts.get(id.getName());
    if (varDef == null) {
      System.out.println("Error: Variable " + id.getName() + " not defined.");
    } else {
      id.setDefinition(varDef);
    }
    return null;
  }
}
