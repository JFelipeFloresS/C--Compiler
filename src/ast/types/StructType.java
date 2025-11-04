package ast.types;

import ast.locatable.Locatable;
import visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {

    private final List<StructRecordField> fields;
    public List<StructRecordField> getFields() {
        return fields;
    }

    public StructType(int line, int column, List<StructRecordField> fields) {
        super(line, column);
        this.fields = fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform arithmetic operation between %s and %s", this, that), node);
    }

    @Override
    public Type assignment(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform assignment operation between %s and %s", this, that), node);
    }

    @Override
    public Type cast(Type that, Locatable node) {
        if (that instanceof ErrorType)
            return that;
        return new ErrorType(String.format("Cannot perform cast operation between %s and %s", this, that), node);
    }

    @Override
    public Type relational(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
    }

    @Override
    public Type logical(Type that, Locatable node) {
        return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
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
}
