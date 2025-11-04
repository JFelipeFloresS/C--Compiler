package ast.types;

import ast.definitions.VariableDefinition;
import ast.locatable.Locatable;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;

public class FunctionType extends AbstractType {

  private final List<VariableDefinition> params;
  public List<VariableDefinition> getParams() {
    return params;
  }

  private final Type returnType;
  public Type getReturnType() {
    return returnType;
  }

  public FunctionType(int line, int column, Type returnType, List<VariableDefinition> params) {
    super(line, column);
    this.params = params;
    this.returnType = returnType;
  }

  @Override
  public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
    return visitor.visit(this, param);
  }

  @Override
  public Type arithmetic(Type that, Locatable node) {
    if (that instanceof ErrorType)
      return that;
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
    if (that instanceof ErrorType)
      return that;
    return new ErrorType(String.format("Cannot perform relational operation between %s and %s", this, that), node);
  }

  @Override
  public Type logical(Type that, Locatable node) {
    if (that instanceof ErrorType)
      return that;
    return new ErrorType(String.format("Cannot perform logical operation between %s and %s", this, that), node);
  }

  @Override
  public String toString() {
    StringBuilder paramsStr = new StringBuilder();
    for (int i = 0; i < params.size(); i++) {
      paramsStr.append(params.get(i).getType().toString());
      if (i < params.size() - 1) {
        paramsStr.append(", ");
      }
    }
    return String.format(
        "FunctionType (%d, %d): (%s) params(%s)",
        this.getLine(),
        this.getColumn(),
        returnType.toString(),
        paramsStr
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof FunctionType that)) {
      System.out.println("Object is not a FunctionType " + o);
      return false;
    }
    if (this.getLine() != that.getLine()) {
      System.out.println("FunctionType line numbers differ: " + this.getLine() + " != " + that.getLine());
      return false;
    }

    if (this.getColumn() != that.getColumn()) {
      System.out.println("FunctionType column numbers differ: " + this.getColumn() + " != " + that.getColumn());
      return false;
    }

    if (!this.returnType.equals(that.returnType)) {
      System.out.println("FunctionType return types differ: " + this.returnType + " != " + that.returnType);
      return false;
    }

    if (this.params.size() != that.params.size()) {
      System.out.println("FunctionType parameter list sizes differ: " + this.params.size() + " != " + that.params.size());
      return false;
    }

    if (!Objects.deepEquals(this.params, that.params)) {
      System.out.println("FunctionType parameter lists differ: " +
          String.join(", ", this.params.stream().map(VariableDefinition::toString).toArray(String[]::new)) + " != " +
          String.join(", ", that.params.stream().map(VariableDefinition::toString).toArray(String[]::new)));
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        Integer.hashCode(getLine()),
        Integer.hashCode(getColumn()),
        returnType.hashCode(),
        params.hashCode()
    );
  }
}
