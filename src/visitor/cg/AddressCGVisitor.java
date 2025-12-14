package visitor.cg;

import ast.expressions.ArrayAccess;
import ast.expressions.Id;
import ast.expressions.StructAccess;
import cg.CG;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {
	private ValueCGVisitor valueCGVisitor;

	public AddressCGVisitor(CG gc, ValueCGVisitor valueCGVisitor) {
		super(gc);
		this.valueCGVisitor = valueCGVisitor;
	}

	@Override
	public Void visit(Id id, Void param) {
		// * Pushes the address of id
		cg.pushAddress(id);
		return null;
	}

	@Override
	public Void visit(ArrayAccess arrayAccess, Void param) {
		// base address
		arrayAccess.getArray().accept(this, param);
		// index
		arrayAccess.getIndex().accept(this.valueCGVisitor, param);

		cg.pushAddress(arrayAccess);

		return null;
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		// * Pushes the address of the struct field
		structAccess.getStructExpression().accept(this, param);
		cg.pushAddress(structAccess);
		return null;
	}
}
