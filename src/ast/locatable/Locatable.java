package ast.locatable;

import ast.ASTNode;

public interface Locatable extends ASTNode {

	int getLine();

	int getColumn();

}
