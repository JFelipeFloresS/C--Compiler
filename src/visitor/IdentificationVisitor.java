package visitor;

import ast.definitions.Definition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;

import java.util.HashMap;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

  HashMap<String, VariableDefinition> stmts = new HashMap<>();

  @Override
  public Void visit(VariableDefinition varDef, Void param) {
    String existing = varDef.getNames().stream().filter(name -> stmts.containsKey(name)).findFirst().orElse(null);
    if (existing != null) {
      System.out.println("Error: Variable " + existing + " already defined.");
    } else {
      varDef.getNames().forEach(name -> stmts.put(name, varDef));
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
