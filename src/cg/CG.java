package cg;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.locatable.Locatable;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;
import ast.types.Type;

import java.io.IOException;
import java.io.PrintWriter;

public class CG {
	/**
	 * The output file
	 */
	private PrintWriter out;

	private int insetLevel = 0;

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
				out.flush();
			}
			case DoubleType _ when toType instanceof IntType -> {
				out.println(getInset() + "f2i");
				out.flush();
			}
			case CharType _ when toType instanceof IntType -> {
				out.println(getInset() + "b2i");
				out.flush();
			}
			case IntType _ when toType instanceof CharType -> {
				out.println(getInset() + "i2b");
				out.flush();
			}
			case CharType _ when toType instanceof DoubleType -> {
				out.println(getInset() + "b2i");
				out.println(getInset() + "i2f");
				out.flush();
			}
			case DoubleType _ when toType instanceof CharType -> {
				out.println(getInset() + "f2i");
				out.println(getInset() + "i2b");
				out.flush();
			}
			default -> throw new RuntimeException("Unsupported cast from " + fromType + " to " + toType);
		}
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
		out.flush();
		insetLevel++;
	}

	public void endFunctionDeclaration(FunctionDefinition functionDefinition) {
		// TODO figure out how to set the return value properly
		out.println(getInset() + "ret\t0, 0, 0");
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
		pusha(offset);
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
		comment("Invocation to the main function");
		out.println("call main");
		out.println("halt");
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
