package ast.statements;

import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class Write extends AbstractStatement {

    private final List<Expression> expressions;

    public Write(int line, int column, List<Expression> expressions) {
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
            "Write (%d, %d):%n\t" +
                "expressions: %s",
            getLine(),
            getColumn(),
            exprString
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Write that)) {
            System.out.println("Not a Write instance");
            return false;
        }
        if (this.getLine() != that.getLine()) {
            System.out.println("Write line numbers differ: " + this.getLine() + " != " + that.getLine());
            return false;
        }
        if (this.getColumn() != that.getColumn()) {
            System.out.println("Write column numbers differ: " + this.getColumn() + " != " + that.getColumn());
            return false;
        }
        if (this.expressions.size() != that.expressions.size()) {
            System.out.println("Write expressions list sizes differ: " + this.expressions.size() + " != " + that.expressions.size());
            return false;
        }
        for (int i = 0; i < this.expressions.size(); i++) {
            if (!this.expressions.get(i).equals(that.expressions.get(i))) {
                System.out.println("Write expressions at index " + i + " differ: " + this.expressions.get(i) + " != " + that.expressions.get(i));
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return expressions.hashCode();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
