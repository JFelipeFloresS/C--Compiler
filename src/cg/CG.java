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

	public CG(String outputFilename, String sourceFilename) {
		try {
			this.out = new PrintWriter(outputFilename);
		} catch (IOException _) {
			System.err.println("Error opening the file " + outputFilename + ".");
			System.exit(-1);
		}
		source(sourceFilename);
		callMain();
	}

	public String nextLabel() {
		return "label" + (labels++);
	}

	public void label(String label) {
		out.println(label + ":");
		out.flush();
	}

	public void jmpIfFalse(String label) {
		out.println(getInset() + "jz\t" + label);
		out.flush();
	}

	public void jmp(String label) {
		out.println(getInset() + "jmp\t" + label);
		out.flush();
	}

	private String getInset() {
		return "\t".repeat(insetLevel);
	}

	public void output(Type type) {
		out.println(getInset() + "out" + type.suffix());
		out.flush();
	}

	public void input(Type type) {
		out.println(getInset() + "in" + type.suffix());
		out.flush();
	}

	public void pusha(int offset) {
		out.println(getInset() + "pusha\t" + offset);
		out.flush();
	}

	public void load(Type type) {
		out.println(getInset() + "load" + type.suffix());
		out.flush();
	}

	public void store(Type type) {
		out.println(getInset() + "store" + type.suffix());
		out.flush();
	}

	public void add(Type type) {
		out.println(getInset() + "add" + type.suffix());
		out.flush();
	}

	public void sub(Type type) {
		out.println(getInset() + "sub" + type.suffix());
		out.flush();
	}

	public void mul(Type type) {
		out.println(getInset() + "mul" + type.suffix());
		out.flush();
	}

	public void div(Type type) {
		out.println(getInset() + "div" + type.suffix());
		out.flush();
	}

	public void mod(Type type) {
		out.println(getInset() + "mod" + type.suffix());
		out.flush();
	}

	public void push(int constant) {
		out.println(getInset() + "pushi\t" + constant);
		out.flush();
	}

	public void push(double constant) {
		out.println(getInset() + "pushf\t" + constant);
		out.flush();
	}

	public void push(char constant) {
		out.println(getInset() + "pushb\t" + (int) constant);
		out.flush();
	}

	public void comment(String message) {
		out.println(getInset() + "' * " + message);
		out.flush();
	}

	public void cast(Type fromType, Type toType) {
		if (fromType.equals(toType)) {
			return;
		}
		switch (fromType) {
			case IntType _ when toType instanceof DoubleType -> {
				out.println(getInset() + "i2f");
			}
			case DoubleType _ when toType instanceof IntType -> {
				out.println(getInset() + "f2i");
			}
			case CharType _ when toType instanceof IntType -> {
				out.println(getInset() + "b2i");
			}
			case IntType _ when toType instanceof CharType -> {
				out.println(getInset() + "i2b");
			}
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
	 */
	public void declaration(VariableDefinition varDefinition) {
		for (int i = 0; i < varDefinition.getNames().size(); i++) {
			Id currVar = varDefinition.getNames().get(i);
			comment(varDefinition.getType().toString() + " " + currVar.getName() + " (offset " + (varDefinition.getOffset() + (i * varDefinition.getType().numberOfBytes())) + ")");
		}
		out.flush();
	}

	public void declareFunction(FunctionDefinition functionDefinition) {
		out.println("\n" + functionDefinition.getNames().getFirst().getName() + ":");
		insetLevel++;
		comment("Parameters");
		((FunctionType) functionDefinition.getType()).getParams().forEach(this::declaration);
		comment("Local variables");
		functionDefinition.getLocalVars().forEach(this::declaration);
		int localBytes = functionDefinition.getLocalVars().stream().mapToInt(v -> v.getType().numberOfBytes() * v.getNames().size()).sum();
		out.println(getInset() + "enter\t" + localBytes);
		out.flush();
	}

	public void endFunctionDeclaration(FunctionDefinition functionDefinition) {
		FunctionType functionType = (FunctionType) functionDefinition.getType();
		int localBytes = functionDefinition.getLocalVars().stream().mapToInt(v -> v.getType().numberOfBytes() * v.getNames().size()).sum();
		int paramsBytes = functionType.getParams().stream().mapToInt(v -> v.getType().numberOfBytes() * v.getNames().size()).sum();
		out.println(getInset() + "ret\t" + functionType.getReturnType().numberOfBytes() + ", " + localBytes + ", " + paramsBytes);
		out.flush();
		insetLevel--;
	}

	/**
	 * Pushes the address of a local or global variable
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
			out.println(getInset() + "push\tbp");
			out.println(getInset() + "pushi\t" + offset);
			out.println(getInset() + "addi");
			out.flush();
		}
	}

	public void pushArrayElementAddress(ArrayAccess arrayAccess) {
		// * Push size of element
		ArrayType arrayType = (ArrayType) arrayAccess.getArray().getType();
		Type elementType = arrayType.getElementType();
		int elementSize = elementType.numberOfBytes();
		out.println(getInset() + "pushi\t" + elementSize);
		// * Push index
		Type indexType = arrayAccess.getIndex().getType();
		// * Multiply index by the size of the element type
		mul(indexType);
		// * Add to base address
		add(indexType);
		out.flush();
	}

	public void pushStructFieldAddress(StructAccess structAccess) {
		// * Pushes the address of the struct field
		// * Push base address of the struct
		// * Calculate offset of the field
		StructType structType = (StructType) structAccess.getStructExpression().getType();
		int offset = 0;
		String fieldName = structAccess.getFieldName();
		boolean fieldFound = false;
		for (StructRecordField field : structType.getFields()) {
			if (field.getNames().stream().anyMatch(nameId -> nameId.getName().equals(fieldName))) {
				fieldFound = true;
				break;
			}
			offset += field.getType().numberOfBytes() * field.getNames().size();
		}

		if (!fieldFound) {
			throw new IllegalStateException("Field " + fieldName + " not found in struct " + structType);
		}

		// * Add offset to base address
		out.println(getInset() + "pushi\t" + offset);
		out.println(getInset() + "addi");
		out.flush();
	}

	// * To generate debug information

	public void line(Locatable node) {
		out.println("\n#line\t" + node.getLine());
		out.flush();
	}

	private void source(String infilename) {
		out.println("\n#source\t\"" + infilename + "\"\n");
		out.flush();
	}

	private void callMain() {
		callProcedure("main");
		out.println("halt");
		out.flush();
	}

	public void callProcedure(String procName) {
		comment("Invocation to the " + procName + " function");
		out.println(getInset() + "call " + procName);
		out.flush();
	}

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

	public void logicalNot() {
		out.println(getInset() + "not");
		out.flush();
	}
}
