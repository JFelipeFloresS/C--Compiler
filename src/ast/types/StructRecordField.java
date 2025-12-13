package ast.types;

import ast.definitions.VariableDefinition;
import ast.expressions.Id;
import ast.locatable.Locatable;
import visitor.Visitor;

import java.util.List;

public class StructRecordField extends AbstractType {

	private final Type type;
	private final List<Id> names;
	private VariableDefinition structDef;

	public StructRecordField(int line, int column, Type type, List<Id> names) {
		super(line, column);
		this.type = type;
		this.names = names;
	}

	public Type getType() {
		return type;
	}

	public List<Id> getNames() {
		return names;
	}

	@Override
	public Type arithmetic(Type that, Locatable node) {
		return this.getType().arithmetic(that, node);
	}

	@Override
	public Type assignment(Type that, Locatable node) {
		return this.getType().assignment(that, node);
	}

	@Override
	public Type cast(Type that, Locatable node) {
		return this.getType().cast(that, node);
	}

	@Override
	public Type relational(Type that, Locatable node) {
		return this.getType().relational(that, node);
	}

	@Override
	public Type logical(Type that, Locatable node) {
		return this.getType().logical(that, node);
	}

	@Override
	public Type squareBrackets(Type type) {
		return this.getType().squareBrackets(type);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof StructRecordField that)) {
			System.out.println("Not instance of RecordField");
			return false;
		}

		if (this.getLine() != that.getLine()) {
			System.out.println("RecordField line numbers differ: " + this.getLine() + " != " + that.getLine());
			return false;
		}
		if (this.getColumn() != that.getColumn()) {
			System.out.println("RecordField column numbers differ: " + this.getColumn() + " != " + that.getColumn());
			return false;
		}
		if (!this.type.equals(that.type)) {
			System.out.println("RecordField types differ: " + this.type + " != " + that.type);
			return false;
		}

		if (this.names.size() != that.names.size()) {
			System.out.println("RecordField names size differ: " + this.names + " != " + that.names);
			return false;
		}

		for (int i = 0; i < this.names.size(); i++) {
			if (!this.names.get(i).equals(that.names.get(i))) {
				System.out.println("RecordField names differ at index " + i + ": " + this.names.get(i) + " != " + that.names.get(i));
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		return type.hashCode() + names.hashCode() + Integer.hashCode(getLine()) + Integer.hashCode(getColumn());
	}

	@Override
	public char suffix() {
		return type.suffix();
	}

	@Override
	public int numberOfBytes() {
		return type.numberOfBytes() * names.size();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public VariableDefinition getStructDef() {
		return structDef;
	}

	public void setStructDef(VariableDefinition structDef) {
		this.structDef = structDef;
	}
}
