package ast.locatable;

import ast.ASTNode;

public interface Locatable extends ASTNode {

    public int getLine();

    public int getColumn();

}
