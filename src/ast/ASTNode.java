/**
 * Generic type for any AST node. Any node should provide its line and column in the source program.
 * @see The default implementation in AbstractASTNode
 * 
 * @author  Francisco Ortin
 */

package ast;

import visitor.Visitor;

public interface ASTNode {

	public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);

}

