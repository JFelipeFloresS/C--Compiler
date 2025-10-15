package ast.statements;

import ast.expressions.Expression;

import java.util.List;

public class Read extends AbstractStatement {

    private final List<Expression> expressions;

    public Read(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        String exprString = String.join(", ", expressions.stream().map(e -> e.getClass().getSimpleName()).toArray(String[]::new));
        return String.format(
                "Read:%s" +
                "expressions: %s",
                "\n\t",
                exprString
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Read that)) return false;

        if (this.getLine() != that.getLine()) return false;
        if (this.getColumn() != that.getColumn()) return false;

        if (this.expressions.size() != that.expressions.size()) return false;
        for (int i = 0; i < this.expressions.size(); i++) {
            if (!this.expressions.get(i).equals(that.expressions.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return expressions.hashCode();
    }
}
