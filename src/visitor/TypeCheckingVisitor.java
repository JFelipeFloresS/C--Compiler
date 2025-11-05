package visitor;

import ast.expressions.*;
import ast.statements.Assignment;
import ast.types.ArrayType;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    // STATEMENTS

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.getTarget().accept(this, null);
        assignment.getValue().accept(this, null);

        if (assignment.getTarget().getType() != null && assignment.getValue().getType() != null) {
            // Store the result of the assignment method as the assignment's type
            assignment.setType(
                assignment.getTarget().getType().assignment(assignment.getValue().getType(), assignment)
            );
        }
        return null;
    }

    // EXPRESSIONS

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getLeft().accept(this, null);
        arithmetic.getRight().accept(this, null);

        if (arithmetic.getLeft().getType() != null && arithmetic.getRight().getType() != null) {
            arithmetic.setType(
                arithmetic.getLeft().getType().arithmetic(arithmetic.getRight().getType(), arithmetic)
            );
        }
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void param) {
        arrayAccess.getArray().accept(this, null);
        arrayAccess.getIndex().accept(this, null);
        arrayAccess.setType(arrayAccess.getArray().getType());
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);
        logical.setType(
            logical.getLeft().getType().logical(logical.getRight().getType(),
                logical));
        return null;
    }

    @Override
    public Void visit(LogicalNot logicalNot, Void param) {
        logicalNot.getExpression().accept(this, null);
        logicalNot.setType(logicalNot.getExpression().getType());
        return null;
    }

    @Override
    public Void visit(Parenthesis parenthesis, Void param) {
        parenthesis.getExpression().accept(this, null);
        parenthesis.setType(parenthesis.getExpression().getType());
        return null;
    }

    @Override
    public Void visit(Relational relational, Void param) {
        relational.getLeft().accept(this, null);
        relational.getRight().accept(this, null);
        relational.setType(
            relational.getLeft().getType().relational(relational.getRight().getType(),
                relational));
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess, Void param) {
        structAccess.getStructExpression().accept(this, null);
        structAccess.setType(structAccess.getStructExpression().getType());
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExpression().accept(this, null);
        unaryMinus.setType(unaryMinus.getExpression().getType());
        return null;
    }

    @Override
    public Void visit(ArrayType arrayType, Void param) {
        arrayType.getElementType().accept(this, null);
        return null;
    }

}
