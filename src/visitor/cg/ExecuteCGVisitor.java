package visitor.cg;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;
import ast.types.FunctionType;
import cg.CG;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {
	private final AddressCGVisitor addressCGVisitor;

	private final ValueCGVisitor valueCGVisitor;

	public ExecuteCGVisitor(CG cg) {
		super(cg);
		this.valueCGVisitor = new ValueCGVisitor(cg);
		this.addressCGVisitor = new AddressCGVisitor(cg);
	}

	@Override
	public Void visit(Write write, Void param) {
		cg.comment("Write");
		write.getExpressions().forEach(w -> {
			w.accept(this.valueCGVisitor, null);
			cg.output(w.getType());
		});
		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		cg.comment("Read");
		read.getExpressions().forEach(r -> {
			r.accept(this.addressCGVisitor, null);
			cg.input(r.getType());
			cg.store(r.getType());
		});
		return null;
	}

	@Override
	public Void visit(Program program, Void param) {
		program.definitions().forEach(def ->
			{
				if (!(def instanceof VariableDefinition))
					cg.line(def);
				def.accept(this, null);
			}
		);
		return null;
	}

	@Override
	public Void visit(VariableDefinition varDefinition, Void param) {
		cg.declaration(varDefinition);
		return null;
	}

	@Override
	public Void visit(FunctionDefinition functionDefinition, Void param) {
		cg.comment("Function definition: " + functionDefinition.getNames().getFirst());
		cg.declareFunction(functionDefinition);
		((FunctionType) functionDefinition.getType()).getParams().forEach(p -> {
			cg.declaration(p);
		});
		functionDefinition.getLocalVars().forEach(varDef -> {
			cg.declaration(varDef);
		});
		functionDefinition.getStmtsBlock().forEach(stmt -> {
			cg.line(stmt);
			stmt.accept(this, null);
		});
		cg.endFunctionDeclaration(functionDefinition);
		return null;
	}

	@Override
	public Void visit(Assignment assignment, Void param) {
		cg.comment("Assignment");
		assignment.getTarget().accept(this.addressCGVisitor, null); // * lvalue
		assignment.getValue().accept(this.valueCGVisitor, null); // * rvalue
		cg.store(assignment.getTarget().getType());
		return null;
	}
}
