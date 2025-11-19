package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.expressions.StructAccess;
import ast.statements.Return;
import ast.types.ErrorType;
import ast.types.StructRecordField;
import ast.types.StructType;
import ast.types.Type;
import symboltable.SymbolTable;

import static utils.TypeMismatchErrorUtils.getFieldNotFoundError;
import static utils.TypeMismatchErrorUtils.getNonStructTypeError;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

	private final SymbolTable symbolTable = new SymbolTable();

	@Override
	public Void visit(VariableDefinition varDef, Void param) {
		symbolTable.insert(varDef);
		if (varDef.getType() instanceof StructType structType) {
			for (StructRecordField field : structType.getFields()) {
				field.getType().accept(this, param);
			}
		} else {
			varDef.getType().accept(this, param);
		}
		return null;
	}

	@Override
	public Void visit(FunctionDefinition funcDef, Void param) {
		if (!symbolTable.insert(funcDef)) {
			return null;
		}

		symbolTable.set(funcDef);
		funcDef.getType().accept(this, param); // visits params
		for (var varDef : funcDef.getLocalVars()) {
			varDef.accept(this, param);
		}
		for (var stmt : funcDef.getStmtsBlock()) {
			stmt.accept(this, param);
		}

		symbolTable.reset();
		return null;
	}

	@Override
	public Void visit(Id id, Void param) {
		id.setScope(symbolTable.getCurrentScope());
		Definition varDef = symbolTable.find(id.getName());
		if (varDef == null) {
			id.setType(new ErrorType("Error: Variable \"" + id.getName() + "\" not defined in " + symbolTable.getScopeName(symbolTable.getCurrentScope()), id));
		} else {
			id.setScope(symbolTable.getCurrentScope());
			id.setDefinition(varDef);
			id.setType(varDef.getType());
		}
		return null;
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		structAccess.getStructExpression().accept(this, null);
		Type structAccessType = structAccess.getStructExpression().getType();
		if (structAccessType instanceof StructType structType) {
			StructRecordField field = structType.getField(structAccess.getFieldName());
			if (field != null) {
				structAccess.setStructRecordField(field);
				structAccess.setType(field.getType());
			} else {
				structAccess.setType(getFieldNotFoundError(structAccess.getFieldName(), structAccess));
			}
		} else if (!(structAccessType instanceof ErrorType)) {
			structAccess.setType(getNonStructTypeError(structAccess));
		}
		return null;
	}

	@Override
	public Void visit(StructType structType, Void param) {
		if (structType.getStructDefinition() == null) {
			for (StructRecordField field : structType.getFields()) {
				field.accept(this, param);
			}
		}
		return null;
	}

	@Override
	public Void visit(StructRecordField recordField, Void param) {
		recordField.getType().accept(this, param);
		return null;
	}

	@Override
	public Void visit(Return _return, Void param) {
		_return.getExpression().accept(this, null);
		_return.setFuncDef(symbolTable.getFunctionDefinitionByScope(symbolTable.getCurrentScope()));

		return null;
	}

	@Override
	public Void visit(Program program, Void param) {
		super.visit(program, param);
		symbolTable.reset();
		return null;
	}

}
