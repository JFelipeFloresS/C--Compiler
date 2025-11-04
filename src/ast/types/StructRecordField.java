package ast.types;

import ast.expressions.Id;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class StructRecordField extends AbstractLocatable {

  private final Type type;
  public Type getType() {
    return type;
  }
  private final List<Id> names;
  public List<Id> getNames() {
    return names;
  }

  public StructRecordField(int line, int column, Type type, List<Id> names) {
    super(line, column);
    this.type = type;
    this.names = names;
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
  public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
    this.type.accept(visitor, param);
    for (Id name : this.names) {
      name.accept(visitor, param);
    }
    return null;
  }
}
