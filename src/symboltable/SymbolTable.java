package symboltable;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private final List<Map<String, Definition>> table;
    private int scope = 0;

    public SymbolTable() {
        this.table = new ArrayList<>();
        this.table.add(new HashMap<>()); // Global scope
    }

    public int getCurrentScope() {
        return scope;
    }

    public void set() {
        scope = table.size();
        table.add(new HashMap<>());
    }

    public void reset() {
        if (scope > 0) {
            table.get(scope).clear();
            scope--;
        }
    }

    public boolean insert(Definition definition) {
        // returns whether the definition could be inserted or not (i.e., there was another definition for that variable)
        if (definition == null) {
            return false;
        }
        definition.setScope(scope);
        for (var name : definition.getNames()) {
            name.setScope(scope);
            String id = name.getName();
            if (table.get(scope).containsKey(id)) {
                return false; // Definition already exists in the current scope
            }
            table.get(scope).put(id, definition);
        }
        return true;
    }

    public Definition find(String id) {
        for (int i = scope; i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return table.get(i).get(id);
            }
        }
        return null;
    }

    public String getScopeName(int scope) {
        if (scope == 0) {
            return "global scope";
        }

        // return the name of the function that defines this scope
        int funcCount = 0;
        for (var def : table.getFirst().values()) {
            if (def instanceof FunctionDefinition) {
                funcCount++;
                if (funcCount == scope) {
                    return "function " + def.getNames().getFirst().getName();
                }
            }
        }

        return "unknown";
    }
}
