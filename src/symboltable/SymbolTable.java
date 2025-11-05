package symboltable;

import ast.definitions.Definition;

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

    public void set() {
        scope++;
        if (table.size() <= scope) {
            table.add(new HashMap<>());
        } else {
            table.get(scope).clear();
        }
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
        for (var name : definition.getNames()) {
            String id = name.getName();
            if (table.get(scope).containsKey(id)) {
                return false; // Definition already exists in the current scope
            }
            table.get(scope).put(id, definition);
        }
        definition.getNames().forEach(name -> name.setScope(scope));
        definition.setScope(scope);
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

}
