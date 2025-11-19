package symboltable;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.types.ErrorType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

	private final List<Map<String, Definition>> table;
	private final Map<Integer, FunctionDefinition> scopeFunction = new HashMap<>();
	private int scope = 0;

	public SymbolTable() {
		this.table = new ArrayList<>();
		this.table.add(new HashMap<>()); // Global scope
	}

	public int getCurrentScope() {
		return scope;
	}

	public void set(FunctionDefinition funcDef) {
		scope = table.size();
		table.add(new HashMap<>());
		scopeFunction.put(scope, funcDef);
	}

	public void set() {
		scope = table.size();
		table.add(new HashMap<>());
	}

	public void reset() {
		scope = 0;
	}

	public boolean insert(Definition definition) {
		// returns whether the definition could be inserted or not (i.e., there was another definition for that variable)
		int insertScope = scope;
		// Ensure function definitions are always inserted in global scope
		if (definition instanceof FunctionDefinition) {
			insertScope = 0;
		}
		definition.setScope(insertScope);
		for (var name : definition.getNames()) {
			name.setScope(insertScope);
			String id = name.getName();
			if (table.get(insertScope).containsKey(id)) {
				name.setType(new ErrorType("Error: Variable \"" + id + "\" already defined in " + getScopeName(insertScope), name));
				return false; // Definition already exists in the current scope
			}
			table.get(insertScope).put(id, definition);
			name.setDefinition(definition);
		}
		return true;
	}

	public Definition find(String id) {
		if (table.get(scope).containsKey(id)) {
			return table.get(scope).get(id);
		} else if (scope != 0 && table.getFirst().containsKey(id)) {
			return table.getFirst().get(id);
		}
		return null;
	}

	public String getScopeName(int scope) {
		if (scope == 0) {
			return "global scope";
		}

		// return the name of the function that defines this scope
		FunctionDefinition def = getFunctionDefinitionByScope(scope);
		if (def != null)
			return "function " + def.getNames().getFirst().getName();

		return "unknown";
	}

	public FunctionDefinition getFunctionDefinitionByScope(int scope) {
		return scopeFunction.get(scope);
	}
}
