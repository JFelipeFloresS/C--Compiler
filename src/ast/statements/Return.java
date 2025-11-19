package ast.statements;

import ast.definitions.FunctionDefinition;
import ast.expressions.Expression;
import visitor.Visitor;

public class Return extends AbstractStatement {

    private final Expression expression;
    private FunctionDefinition funcDef;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format(
            "Return (%d, %d):%n\t" +
                "expression: %s",
            this.getLine(),
            this.getColumn(),
            expression.getClass().getSimpleName()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Return other)) {
            return false;
        }
        return this.getLine() == other.getLine()
            && this.getColumn() == other.getColumn()
            && ((this.expression == null && other.expression == null)
            || (this.expression != null && this.expression.equals(other.expression)));
    }

    @Override
    public int hashCode() {
        return (expression == null) ? 0 : expression.hashCode();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public FunctionDefinition getFuncDef() {
        return funcDef;
    }

    public void setFuncDef(FunctionDefinition funcDef) {
        this.funcDef = funcDef;
    }
}
