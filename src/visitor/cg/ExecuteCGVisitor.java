package visitor.cg;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.*;
import cg.CG;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {
	private final AddressCGVisitor addressCGVisitor;

	private final ValueCGVisitor valueCGVisitor;

	public ExecuteCGVisitor(CG cg) {
		super(cg);
		this.valueCGVisitor = new ValueCGVisitor(cg);
		this.addressCGVisitor = new AddressCGVisitor(cg, this.valueCGVisitor);
	}

	@Override
	public Void visit(Write write, Void param) {
		cg.line(write);
		cg.comment("Write");
		write.getExpressions().forEach(w -> {
			w.accept(this.valueCGVisitor, null);
			cg.output(w.getType());
		});
		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		cg.line(read);
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
		functionDefinition.getStmtsBlock().forEach(stmt -> stmt.accept(this, null));
		cg.endFunctionDeclaration(functionDefinition);
		return null;
	}

	@Override
	public Void visit(Assignment assignment, Void param) {
		cg.line(assignment);
		cg.comment("Assignment");
		assignment.getTarget().accept(this.addressCGVisitor, null); // * lvalue
		assignment.getValue().accept(this.valueCGVisitor, null); // * rvalue
		cg.store(assignment.getTarget().getType());
		return null;
	}

	@Override
	public Void visit(ProcedureInvocation procedureInvocation, Void param) {
		cg.line(procedureInvocation);
		cg.comment("Procedure Invocation: " + procedureInvocation.getProcedureId().getName());
		procedureInvocation.getParameters().forEach(arg -> arg.accept(this.valueCGVisitor, null));
		cg.callProcedure(procedureInvocation.getProcedureId().getName());
		return null;
	}

	@Override
	public Void visit(While whileStmtm, Void param) {
		cg.line(whileStmtm);
		cg.comment("While");
		String startLabel = cg.nextLabel();
		String endLabel = cg.nextLabel();
		cg.label(startLabel);
		whileStmtm.getCondition().accept(this.valueCGVisitor, null);
		cg.jmpIfFalse(endLabel);
		cg.comment("Body of the while statement");
		whileStmtm.getThenStatements().forEach(stmt -> stmt.accept(this, null));
		cg.jmp(startLabel);
		cg.label(endLabel);
		return null;
	}

	@Override
	public Void visit(IfElse ifElseStmtm, Void param) {
		cg.line(ifElseStmtm);
		cg.comment("If statement");
		String elseLabel = cg.nextLabel();
		String endLabel = cg.nextLabel();
		ifElseStmtm.getCondition().accept(this.valueCGVisitor, null);
		cg.jmpIfFalse(elseLabel);
		cg.comment("Body of the if branch");
		ifElseStmtm.getThenStatements().forEach(stmt -> stmt.accept(this, null));
		cg.jmp(endLabel);
		cg.label(elseLabel);
		if (!ifElseStmtm.getElseStatements().isEmpty()) {
			cg.comment("Body of the else branch");
			ifElseStmtm.getElseStatements().forEach(stmt -> stmt.accept(this, null));
		}
		cg.label(endLabel);
		return null;
	}
}
