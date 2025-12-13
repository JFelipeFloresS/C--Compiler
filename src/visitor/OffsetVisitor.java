package visitor;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.types.FunctionType;
import ast.types.StructType;

public class OffsetVisitor extends AbstractVisitor<Void, Void> {

	/**
	 * To compute the offsets of global variables
	 */
	private int bytesGlobalsSum = 0;

	@Override
	public Void visit(Program program, Void p) {
		for (var def : program.definitions()) {
			if (def instanceof VariableDefinition) {
				def.accept(this, p);
			}
		}
		for (var def : program.definitions()) {
			if (def instanceof FunctionDefinition) {
				def.accept(this, p);
			}
		}
		return null;
	}

	@Override
	public Void visit(FunctionDefinition funcDefinition, Void p) {
		FunctionType funcType = (FunctionType) funcDefinition.getType();

		// Calculate parameter offsets (positive, starting from 4)
		int paramsBytesSum = 4;
		for (int i = funcType.getParams().size() - 1; i >= 0; i--) {
			VariableDefinition param = funcType.getParams().get(i);
			param.setOffset(paramsBytesSum);
			paramsBytesSum += param.getType().numberOfBytes();
		}

		// Calculate local variable offsets (negative)
		int localBytesSum = 0;
		for (VariableDefinition varDef : funcDefinition.getLocalVars()) {
			localBytesSum += varDef.getType().numberOfBytes();
			varDef.setOffset(-localBytesSum);
		}

		return null;
	}

	@Override
	public Void visit(VariableDefinition varDefinition, Void param) {
		varDefinition.setOffset(bytesGlobalsSum);
		bytesGlobalsSum += varDefinition.getType().numberOfBytes();
		return null;
	}

	@Override
	public Void visit(StructType structType, Void p) {
		return null;
	}
}
