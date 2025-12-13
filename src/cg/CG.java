package cg;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.Id;
import ast.expressions.StructAccess;
import ast.locatable.Locatable;
import ast.types.*;

import java.io.IOException;
import java.io.PrintWriter;

public class CG {
	/**
	 * The output file
	 */
	private PrintWriter out;

	private int insetLevel = 0;

	private int labels = 0;

	public CG(String sourceFilename, String outputFilename) {
		try {
			this.out = new PrintWriter(outputFilename);
		} catch (IOException _) {
			System.err.println("Error opening the file " + outputFilename + ".");
			System.exit(-1);
		}
		source(sourceFilename);
		callMain();
	}

	/**
	 * Generates a new unique label string
	 *
	 * @return the label string
	 */
	public String nextLabel() {
		return "label" + (labels++);
	}

	/**
	 * Generates a label
	 *
	 * @param label the label string
	 */
	public void label(String label) {
		out.println(label + ":");
		out.flush();
	}

	/**
	 * Generates a jump if false to the given label
	 *
	 * @param label the label to jump to
	 */
	public void jmpIfFalse(String label) {
		out.println(getInset() + "jz\t" + label);
		out.flush();
	}

	/**
	 * Generates an unconditional jump to the given label
	 *
	 * @param label the label to jump to
	 */
	public void jmp(String label) {
		out.println(getInset() + "jmp\t" + label);
		out.flush();
	}

	/**
	 * Generates the current inset string (number of tabs)
	 *
	 * @return the inset string
	 */
	private String getInset() {
		return "\t".repeat(insetLevel);
	}

	/**
	 * Outputs a value of the given type in the output file
	 *
	 * @param type the type of the value to output
	 */
	public void output(Type type) {
		out.println(getInset() + "out" + type.suffix());
		out.flush();
	}

	/**
	 * Inputs a value of the given type in the output file
	 *
	 * @param type the type of the value to input
	 */
	public void input(Type type) {
		out.println(getInset() + "in" + type.suffix());
		out.flush();
	}

	public void pushBasePointer() {
		out.println(getInset() + "push\tbp");
		out.flush();
	}

	/**
	 * Pushes the address given by the offset in the output file
	 *
	 * @param offset the offset to push
	 */
	public void pusha(int offset) {
		out.println(getInset() + "pusha\t" + offset);
		out.flush();
	}

	/**
	 * Loads a value of the given type from the address on top of the stack in the output file
	 *
	 * @param type the type of the value to load
	 */
	public void load(Type type) {
		out.println(getInset() + "load" + type.suffix());
		out.flush();
	}

	/**
	 * Stores a value of the given type to the address on top of the stack in the output file
	 *
	 * @param type the type of the value to store
	 */
	public void store(Type type) {
		out.println(getInset() + "store" + type.suffix());
		out.flush();
	}

	/**
	 * Adds two values of the given type in the output file
	 *
	 * @param type the type of the values to add
	 */
	public void add(Type type) {
		out.println(getInset() + "add" + type.suffix());
		out.flush();
	}

	/**
	 * Subtracts two values of the given type in the output file
	 *
	 * @param type the type of the values to subtract
	 */
	public void sub(Type type) {
		out.println(getInset() + "sub" + type.suffix());
		out.flush();
	}

	/**
	 * Multiplies two values of the given type in the output file
	 *
	 * @param type the type of the values to multiply
	 */
	public void mul(Type type) {
		out.println(getInset() + "mul" + type.suffix());
		out.flush();
	}

	/**
	 * Divides two values of the given type in the output file
	 *
	 * @param type the type of the values to divide
	 */
	public void div(Type type) {
		out.println(getInset() + "div" + type.suffix());
		out.flush();
	}

	/**
	 * Computes the modulus of two values of the given type in the output file
	 *
	 * @param type the type of the values to compute the modulus
	 */
	public void mod(Type type) {
		out.println(getInset() + "mod" + type.suffix());
		out.flush();
	}

	/**
	 * Pushes an integer constant in the output file
	 *
	 * @param constant the integer constant to push
	 */
	public void push(int constant) {
		out.println(getInset() + "pushi\t" + constant);
		out.flush();
	}

	/**
	 * Pushes a double constant in the output file
	 *
	 * @param constant the double constant to push
	 */
	public void push(double constant) {
		out.println(getInset() + "pushf\t" + constant);
		out.flush();
	}

	/**
	 * Pushes a char constant in the output file
	 *
	 * @param constant the char constant to push
	 */
	public void push(char constant) {
		out.println(getInset() + "pushb\t" + (int) constant);
		out.flush();
	}

	/**
	 * Generates a comment in the output file
	 *
	 * @param message the comment message
	 */
	public void comment(String message) {
		String[] messageLines = message.split("\n");
		// make sure multiple lines are commented properly
		for (String line : messageLines) {
			out.println(getInset() + "' * " + line);
		}
		out.flush();
	}

	/**
	 * Casts a value from one type to another in the output file
	 *
	 * @param fromType the type of the value to cast
	 * @param toType   the type to cast to
	 */
	public void cast(Type fromType, Type toType) {
		// if same type, no cast needed
		if (fromType.equals(toType)) {
			return;
		}
		switch (fromType) {
			case IntType _ when toType instanceof DoubleType -> out.println(getInset() + "i2f");
			case DoubleType _ when toType instanceof IntType -> out.println(getInset() + "f2i");
			case CharType _ when toType instanceof IntType -> out.println(getInset() + "b2i");
			case IntType _ when toType instanceof CharType -> out.println(getInset() + "i2b");

			// extra steps for char <-> double
			case CharType _ when toType instanceof DoubleType -> {
				out.println(getInset() + "b2i");
				out.println(getInset() + "i2f");
			}
			case DoubleType _ when toType instanceof CharType -> {
				out.println(getInset() + "f2i");
				out.println(getInset() + "i2b");

			}
			default -> throw new RuntimeException("Unsupported cast from " + fromType + " to " + toType);
		}
		out.flush();
	}

	/**
	 * Variable definition generates one comment for readability purposes
	 *
	 * @param varDefinition the variable definition
	 */
	public void declaration(VariableDefinition varDefinition) {
		for (int i = 0; i < varDefinition.getNames().size(); i++) {
			Id currVar = varDefinition.getNames().get(i);
			comment(varDefinition.getType().toString() + " " + currVar.getName() + " (offset " + (varDefinition.getOffset() + (i * varDefinition.getType().numberOfBytes())) + ")");
		}
		out.flush();
	}

	/**
	 * Function definition generates the function prologue in the output file
	 * declaring parameters and local variables
	 * and reserving space in the stack
	 *
	 * @param functionDefinition the function definition
	 */
	public void declareFunction(FunctionDefinition functionDefinition) {
		// reset inset level for each function
		insetLevel = 0;

		// function label
		out.println("\n" + functionDefinition.getNames().getFirst().getName() + ":");

		// increase inset level for function body
		insetLevel++;

		// comments for parameters and local variables
		comment("Parameters");
		((FunctionType) functionDefinition.getType()).getParams().forEach(this::declaration);
		comment("Local variables");
		functionDefinition.getLocalVars().forEach(this::declaration);

		// reserve space for local variables
		int localBytes = functionDefinition.getLocalVars().stream().mapToInt(v -> v.getType().numberOfBytes()).sum();
		out.println(getInset() + "enter\t" + localBytes);
		out.flush();
	}

	/**
	 * Generates the function epilogue in the output file
	 *
	 * @param functionDefinition the function definition
	 */
	public void returnFunction(FunctionDefinition functionDefinition) {
		FunctionType functionType = (FunctionType) functionDefinition.getType();

		// calculate bytes for local variables and parameters
		int localBytes = functionDefinition.getLocalVars().stream().mapToInt(v -> v.getType().numberOfBytes()).sum();
		int paramsBytes = functionType.getParams().stream().mapToInt(v -> v.getType().numberOfBytes()).sum();

		// return statement with return type, local vars size and params size
		out.println(getInset() + "ret\t" + functionType.getReturnType().numberOfBytes() + ", " + localBytes + ", " + paramsBytes);
		out.flush();

		// reset inset level after function to ensure correct indentation
		insetLevel = 0;
	}

	/**
	 * Pushes the address of a local or global variable in the output file
	 *
	 * @param variable the variable identifier
	 */
	public void pushAddress(Id variable) {
		VariableDefinition varDefinition = (VariableDefinition) variable.getDefinition();
		int initialOffset = varDefinition.getOffset();

		// need to calculate the offset of the specific variable in case of multiple declarations
		int varIndex = varDefinition.getNames().stream().map(Id::getName).toList().indexOf(variable.getName());
		int offset = initialOffset + (varIndex * varDefinition.getType().numberOfBytes());

		if (varDefinition.getScope() == 0) { // Global
			pusha(offset);
		} else { // Local
			pushBasePointer();
			push(offset);
			add(new IntType());
			out.flush();
		}
	}

	/**
	 * Pushes the address of an array element in the output file
	 *
	 * @param arrayAccess the array access expression
	 */
	public void pushArrayElementAddress(ArrayAccess arrayAccess) {
		ArrayType arrayType = (ArrayType) arrayAccess.getArray().getType();
		Type elementType = arrayType.getElementType();
		int elementSize = elementType.numberOfBytes();

		// push size of base type
		push(elementSize);

		Type indexType = arrayAccess.getIndex().getType();

		// multiply index by size of base type to get offset
		mul(indexType);

		// add offset to base address
		add(indexType);
		out.flush();
	}

	/**
	 * Pushes the address of a struct field in the output file
	 *
	 * @param structAccess the struct access expression
	 */
	public void pushStructFieldAddress(StructAccess structAccess) {
		StructType structType = (StructType) structAccess.getStructExpression().getType();

		// calculate field offset
		int offset = 0;
		String fieldName = structAccess.getFieldName(); // name of the field to access
		boolean fieldFound = false;

		// loop through struct fields to find the offset of the desired field
		for (StructRecordField field : structType.getFields()) {
			// since each field can have multiple names, loop through them
			for (int i = 0; i < field.getNames().size(); i++) {
				// if found, calculate offset and break
				if (field.getNames().get(i).getName().equals(fieldName)) {
					fieldFound = true;
					break;
				}
				// if not found, add the size of the entire field (all names) to find the correct offset
				offset += field.getType().numberOfBytes();
			}
			if (fieldFound) {
				break;
			}
		}

		if (!fieldFound) {
			throw new IllegalStateException("Field " + fieldName + " not found in struct " + structType);
		}

		// add field offset to base address
		push(offset);
		add(new IntType());
		out.flush();
	}

	/**
	 * To generate debug information
	 *
	 * @param node the locatable node
	 */
	public void line(Locatable node) {
		out.println("\n#line\t" + node.getLine());
		out.flush();
	}

	/**
	 * To generate debug information
	 *
	 * @param infilename the input filename
	 */
	private void source(String infilename) {
		out.println("\n#source\t\"" + infilename + "\"\n");
		out.flush();
	}

	/**
	 * Calls the main function and halts the program in the output file
	 */
	private void callMain() {
		callProcedure("main", new VoidType());
		out.println("halt");
		out.flush();
	}

	/**
	 * Calls a function in the output file
	 *
	 * @param functionName the function name
	 */
	public void callFunction(String functionName) {
		comment("Invocation to the " + functionName + " function");
		out.println(getInset() + "call\t" + functionName);
		out.flush();
	}

	/**
	 * Calls a procedure in the output file
	 *
	 * @param procedureName the procedure name
	 * @param returnType    the return type of the procedure
	 */
	public void callProcedure(String procedureName, Type returnType) {
		callFunction(procedureName);

		// remove the return value from the stack if not void
		if (!(returnType instanceof VoidType)) {
			out.println(getInset() + "pop" + returnType.suffix());
		}
		out.flush();
	}

	/**
	 * Performs an arithmetic operation in the output file
	 *
	 * @param operator the arithmetic operator
	 * @param type     the type of the operands
	 */
	public void arithmetic(String operator, Type type) {
		switch (operator.charAt(0)) {
			case '+':
				this.add(type);
				break;
			case '-':
				this.sub(type);
				break;
			case '/':
				this.div(type);
				break;
			case '*':
				this.mul(type);
				break;
			case '%':
				this.mod(type);
				break;
			default:
				assert false : "Unknown arithmetic operator";
		}
	}

	/**
	 * Performs a relational operation in the output file
	 *
	 * @param operator the relational operator
	 * @param type     the type of the operands
	 */
	public void relational(String operator, Type type) {
		switch (operator) {
			case "==":
				out.println(getInset() + "eq" + type.suffix());
				break;
			case "!=":
				out.println(getInset() + "ne" + type.suffix());
				break;
			case "<":
				out.println(getInset() + "lt" + type.suffix());
				break;
			case "<=":
				out.println(getInset() + "le" + type.suffix());
				break;
			case ">":
				out.println(getInset() + "gt" + type.suffix());
				break;
			case ">=":
				out.println(getInset() + "ge" + type.suffix());
				break;
			default:
				assert false : "Unknown relational operator";
		}
		out.flush();
	}

	/**
	 * Performs a logical operation in the output file
	 *
	 * @param operator the logical operator
	 */
	public void logical(String operator) {
		switch (operator) {
			case "&&":
				out.println(getInset() + "and");
				break;
			case "||":
				out.println(getInset() + "or");
				break;
			default:
				assert false : "Unknown logical operator";
		}
		out.flush();
	}

	/**
	 * Performs a logical not operation in the output file
	 */
	public void logicalNot() {
		out.println(getInset() + "not");
		out.flush();
	}
}
