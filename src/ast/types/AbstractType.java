/**
  * Default implementation of Type.
  * 
  * @author  Francisco Ortin
  */

package ast.types;


import ast.*;


public abstract class AbstractType implements Type {
	

	/******** Semantic Analysis ***************/
	
	@Override
	public Type arithmetic(Type type, Locatable node) {
		// * By default, not allowed (type error)
		return new ErrorType("An arithmetic expression cannot be performed with the ast.types " + this.getClass().getSimpleName() + " and " + type.getClass().getSimpleName() + ".", node);
	}
	

	@Override
	public Type assignment(Type type, Locatable node) {
		if (type instanceof ErrorType)
			return type;
		if (this.getClass().equals(type.getClass()))
			// * Both operands have the same type
			return type;
		return new ErrorType("Assignments require left- and right-hand sides to have the same type", node);
	}


	/******** Code Generation ***************/
	
	@Override
	public abstract char suffix();
	
	@Override
	public abstract int numberOfBytes();
	
	

}
