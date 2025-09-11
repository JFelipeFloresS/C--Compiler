/**
  * Error handler for semantic errors. 
  * All the semantic errors are represented as a new kind of Type: ErrorType.
  * Assigning ErrorType as the type of one expression means that it is erroneous. 
  * In this way, erroneous and correct expressions are treated uniformly.
  * 
  * @author  Francisco Ortin
  */

package errorhandler;

import java.io.PrintStream;
import java.util.*;

import ast.types.ErrorType;

public class ErrorHandler {

	/**
	 * Singleton: private default constructor
	 */
	private ErrorHandler()  {}
	
	/**
	 * Singleton: unique static instance
	 */
	private static final ErrorHandler instance=new ErrorHandler();
	
	
	/** 
	 * @return Singleton: the unique class instance
	 */
	public static ErrorHandler getErrorHandler() { return instance; }

	
	private final List<ErrorType> errors=new ArrayList<>();
	
	public void addError(ErrorType error) {
		errors.add(error);
	}
	
	public void showErrors(PrintStream out) {
        for (ErrorType error : errors)
			out.println(error);
	}
	
	public boolean anyError() {
		return !errors.isEmpty();
	}
	
}
