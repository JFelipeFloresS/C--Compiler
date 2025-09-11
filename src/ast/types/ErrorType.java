/**
  * ErrorType represents a semantic error in the source program.
  * Assigning ErrorType as the type of one expression means that it is erroneous. 
  * In this way, erroneous and correct expressions are treated uniformly.
  * 
  * @author  Francisco Ortin
  */

package ast.types;


import errorhandler.ErrorHandler;
import visitor.*;
import ast.*;

public class ErrorType extends AbstractType {

	private final String message;
	private final int line, column;
	

	public ErrorType(String message, Locatable astNode) {
		this.message = message;
		this.line = astNode.getLine();
		this.column = astNode.getColumn();
		ErrorHandler.getErrorHandler().addError(this);
	}
	
	@Override
	public Type arithmetic(Type type, Locatable node) {
		return this;
	}

	@Override
	public Type assignment(Type type, Locatable node) {
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("Type error at %d:%d: %s.", this.line, this.column, message);
	}

	@Override
	public int numberOfBytes() {
		throw new RuntimeException("Do not call numberOfBytes on error ast.types");
	}

	@Override
	public char suffix() {
		throw new RuntimeException("Do not call suffix on error ast.types");
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this,param);
	}

}
