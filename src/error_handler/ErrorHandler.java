package error_handler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

  private ErrorHandler() {}

  private static final ErrorHandler instance = new ErrorHandler();

  public static ErrorHandler getErrorHandler() {
    return instance;
  }

  private static final List<ErrorType> errors = new ArrayList<>();

  public void addError(ErrorType error) {
    errors.add(error);
  }

  public boolean anyError() {
    return !errors.isEmpty();
  }

  public void showErrors(PrintStream out) {
    for (ErrorType error : errors) {
      out.println(error);
    }
  }
}
