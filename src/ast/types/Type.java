/**
  * This type generalizes any type in the compiler.
  * Besides representing ast.types, they also hold responsibilities of semantic analysis and code generation.
  * @see AbstractType for the default implementation.
  * 
  * @author  Francisco Ortin
  */

package ast.types;


import ast.ASTNode;
import ast.Locatable;

public interface Type extends ASTNode {
	
	
	/******** Semantic analysis ***************/
	
	Type arithmetic(Type type, Locatable astNode);
	
	Type assignment(Type type, Locatable astNode);

	/******** Code Generation ***************/
	
	char suffix();
	
	int numberOfBytes();
	
	
}
