package visitor.cg;

import ast.expressions.Id;
import cg.CG;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {
	public AddressCGVisitor(CG gc) {
		super(gc);
	}

	@Override
	public Void visit(Id id, Void param) {
		// * Pushes the address of id
		cg.pushAddress(id);
		return null;
	}
}
