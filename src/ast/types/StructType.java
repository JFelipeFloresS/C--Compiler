package ast.types;

import ast.definitions.VariableDefinition;
import visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {

	private final List<StructRecordField> fields;
	private VariableDefinition structDefinition;

	public StructType(int line, int column, List<StructRecordField> fields) {
		super(line, column);
		this.fields = fields;
	}

	public List<StructRecordField> getFields() {
		return fields;
	}

	public StructRecordField getField(String fieldName) {
		for (StructRecordField field : fields) {
			if (field.getNames().stream().anyMatch(id -> id.getName().equals(fieldName))) {
				return field;
			}
		}
		return null;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		StringBuilder fieldStringBuilder = new StringBuilder();
		for (int i = 0; i < fields.size(); i++) {
			fieldStringBuilder.append(fields.get(i).toString());
			if (i < fields.size() - 1) {
				fieldStringBuilder.append("\n");
			}
		}
		return String.format("struct (%d, %d) { %s }",
			this.getLine(),
			this.getColumn(),
			fieldStringBuilder);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof StructType structType)) {
			System.out.println("Not instance of StructType");
			return false;
		}

		if (this.getLine() != structType.getLine()) {
			System.out.println("StructType line numbers differ: " + this.getLine() + " != " + structType.getLine());
			return false;
		}

		if (this.getColumn() != structType.getColumn()) {
			System.out.println("StructType column numbers differ: " + this.getColumn() + " != " + structType.getColumn());
			return false;
		}

		if (this.getStructDefinition() != structType.getStructDefinition()) {
			System.out.println("StructType definitions differ: " + this.getStructDefinition() + " != " + structType.getStructDefinition());
			return false;
		}

		if (this.fields.size() != structType.fields.size()) {
			System.out.println("StructType number of fields differ: " + this.fields.size() + " != " + structType.fields.size());
			return false;
		}

		for (int i = 0; i < this.fields.size(); i++) {
			StructRecordField thisField = this.fields.get(i);
			StructRecordField thatField = structType.fields.get(i);
			if (!thisField.equals(thatField)) {
				System.out.println("StructType fields differ at index " + i + ": " + thisField + " != " + thatField);
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(this.getLine());
		result = 31 * result + Integer.hashCode(this.getColumn());
		for (StructRecordField field : fields) {
			result = 31 * result + field.hashCode();
		}
		return result;
	}

	@Override
	public char suffix() {
		return 's';
	}

	@Override
	public int numberOfBytes() {
		int numberOfBytes = 0;
		for (StructRecordField field : fields) {
			numberOfBytes += field.numberOfBytes();
		}
		return numberOfBytes;
	}

	public VariableDefinition getStructDefinition() {
		return structDefinition;
	}

	public void setStructDefinition(VariableDefinition structDefinition) {
		this.structDefinition = structDefinition;
	}
}
