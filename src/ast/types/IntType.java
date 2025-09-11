/**
  * Internal representation of "int" type in the source language.
  * 
  * @author  Francisco Ortin
  */

package ast.types;

import ast.Locatable;
import visitor.Visitor;

public class IntType extends AbstractType {

	private static final IntType instance=new IntType();
	
	
	public static IntType getInstance() { return instance; }

	
	@Override
	public Type arithmetic(Type type, Locatable node) {
		if (type instanceof ErrorType)
			return type;
		if (type instanceof IntType)
			// int + int -> int
			return this;
		return new ErrorType(String.format(
				"Arithmetic operations of integers do not allow a second operand with type %s",  type),
				node);
	}

	
	@Override
	public char suffix() {
		return 'i';
	}

	@Override
	public int numberOfBytes() {
		return 2;
	}

	
	@Override
	public String toString() {
		return "int";
	}

	

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
		return visitor.visit(this,param);
	}


}
