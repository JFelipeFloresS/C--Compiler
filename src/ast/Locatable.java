/**
 * Generic type for any AST node. Any node should provide its line and column in the source program.
 * @see The default implementation in AbstractASTNode
 * 
 * @author  Francisco Ortin
 */

package ast;

public interface Locatable extends ASTNode {
	/**
	 * Number of line and column where the node appears in the source code
	 */
	public int getLine();

	public int getColumn();

}

