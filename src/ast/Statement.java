
package ast;

import visitor.Visitor;

public interface Statement extends Locatable {

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);

}
