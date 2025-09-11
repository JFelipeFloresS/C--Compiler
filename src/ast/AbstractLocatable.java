/**
 * Default implementation of ASTNode.
 * 
 * @author  Francisco Ortin
 */

package ast;

public abstract class AbstractLocatable implements Locatable {

	private final int line, column;
	
	@Override
	public int getLine() {
		return this.line;
	}
	
	@Override
	public int getColumn() {
		return this.column;
	}

	public AbstractLocatable(int line, int column) {
		this.line = line;
		this.column = column;
	}	
	
}

