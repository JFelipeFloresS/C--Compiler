package ast.types;

import ast.expressions.Expression;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import javax.lang.model.type.TypeVisitor;
import java.util.Objects;

public abstract class AbstractType extends AbstractLocatable implements Type {

    private final Expression size;

    protected AbstractType(int line, int column, Expression size) {
        super(line, column);
        this.size = size;
    }

    public Expression getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format(
            "%s%s",
            this.getClass().getSimpleName(),
            size != null
            ? String.format(
                " arraySize(%s)",
                size.getClass().getSimpleName()
            )
            : ""
        );
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof AbstractType that)) return false;
        return this.getLine() == that.getLine()
            && this.getColumn() == that.getColumn()
            && Objects.equals(this.size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Integer.hashCode(getLine()),
                Integer.hashCode(getColumn()),
                size.hashCode());
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);
}
