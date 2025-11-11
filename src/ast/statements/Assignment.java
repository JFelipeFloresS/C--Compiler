package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

public class Assignment extends AbstractStatement {

    private final Expression target;
    private final Expression value;

    public Assignment(int line, int column, Expression target, Expression value) {
        super(line, column);
        this.target = target;
        this.value = value;
    }

    public Expression getTarget() {
        return target;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format(
            "Assignment:%n\t" +
                "target: %s%n\t" +
                "value: %s",
            target.getClass().getSimpleName(),
            value.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Assignment that)) {
            System.out.println("Not an Assignment instance");
            return false;
        }

        if (this.getLine() != that.getLine()) {
            System.out.println("Assignment Line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }

        if (this.getColumn() != that.getColumn()) {
            System.out.println("Assignment Column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }

        if (!this.target.equals(that.target)) {
            System.out.println("Assignment targets differ");
            return false;
        }

        if (!this.value.equals(that.value)) {
            System.out.println("Assignment values differ");
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getLine());
        result = 31 * result + Integer.hashCode(getColumn());
        result = 31 * result + target.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
