package ast.statements;

import ast.expressions.Expression;

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
                "Assignment:%s" +
                "target: %s%s" +
                "value: %s",
                "\n\t",
                target.getClass().getSimpleName(), "\n\t",
                value.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Assignment)) return false;
        return
            this.getLine() == ((Assignment) obj).getLine() &&
            this.getColumn() == ((Assignment) obj).getColumn() &&
            this.target.equals(((Assignment) obj).target) &&
            this.value.equals(((Assignment) obj).value);
    }

    @Override
    public int hashCode() {
        return 31 * target.hashCode() + value.hashCode();
    }
}
