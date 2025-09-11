/**
  * Internal representation of "double" type in the source language.
  * 
  * @author  Francisco Ortin
  */

package ast.types;

import ast.Locatable;
import visitor.Visitor;

public class RealType extends AbstractType {

	private static final RealType instance=new RealType();
	
	
	public static RealType getInstance() { return instance; }

	@Override
	public Type arithmetic(Type type, Locatable node) {
		if (type instanceof ErrorType)
			return type;
		if (type instanceof RealType)
			// double + double -> double
			return this;
		return new ErrorType(String.format(
				"Arithmetic operations of real expressions do not allow a second operand with type %s",  type),
				node);
	}

	
	@Override
	public char suffix() {
		return 'f';
	}

	@Override
	public int numberOfBytes() {
		return 4;
	}

	@Override
	public String toString() {
		return "double";
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this,param);
	}

}
