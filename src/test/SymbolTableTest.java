/* NOTICE: To run this test, you must pass -ea to the Java Virtual Machine.
   This way, asserts will be enabled and checked. By default, they are disabled.
   java -ea SymbolTableTest 
*/

package test;

import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import symboltable.SymbolTable;

import java.util.List;

public class SymbolTableTest {

	public static void main(String[] args) {
		SymbolTableTest test = new SymbolTableTest();
		test.testInsert();
		test.testFind();
	}

	public void testInsert() {
		SymbolTable st = new SymbolTable();
		VariableDefinition definition = new VariableDefinition(0, 0, null, List.of(new Id(0, 0, "a")));
		assert st.insert(definition);
		assert definition.getScope() == 0;
		assert !st.insert(definition);
		st.set();
		VariableDefinition definition2 = new VariableDefinition(0, 0, null, List.of(new Id(0, 0, "a")));
		assert st.insert(definition2);
		assert definition2.getScope() == 1;
		assert !st.insert(definition2);
		st.reset();
		assert !st.insert(definition);
	}

	public void testFind() {
		SymbolTable st = new SymbolTable();
		VariableDefinition variableDefinition = new VariableDefinition(0, 0, null, List.of(new Id(0, 0, "a")));
		assert st.insert(variableDefinition);
		assert st.find("a") != null;
		assert st.find("b") == null;
		st.set();
		VariableDefinition variableDefinition2 = new VariableDefinition(0, 0, null, List.of(new Id(0, 0, "b")));
		assert st.insert(variableDefinition2);
		assert st.find("b") != null;
		assert st.find("a") != null;
		assert st.find("c") == null;
		st.reset();
		assert st.find("a") != null;
		assert st.find("b") == null;
	}

}
