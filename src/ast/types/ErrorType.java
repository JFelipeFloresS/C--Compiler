package ast.types;

import ast.locatable.Locatable;
import error_handler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType{

  private final String message;

  public ErrorType(String message, Locatable node) {
    super(node.getLine(), node.getColumn());
    this.message = message;
    ErrorHandler.getErrorHandler().addError(this);
  }

  @Override
  public String toString() {
    return String.format("Error (%d, %d): %s", getLine(), getColumn(), message);
  }

  @Override
  public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
    return visitor.visit(this, param);
  }

  @Override
  public Type arithmetic(Type that, Locatable node) {
    return this;
  }

  @Override
  public Type assignment(Type that, Locatable node) {
    return this;
  }

  @Override
  public Type cast(Type that, Locatable node) {
    return this;
  }

  @Override
  public Type relational(Type that, Locatable node) {
    return this;
  }

  @Override
  public Type logical(Type that, Locatable node) {
    return this;
  }
}
