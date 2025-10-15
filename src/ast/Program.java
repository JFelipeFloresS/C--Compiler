package ast;

import ast.statements.Statement;

import java.util.List;

public class Program implements ASTNode {

    private final List<Statement> initialStatements;
    private final List<Statement> mainBlockStatements;

    public Program(List<Statement> initialStatements, List<Statement> mainBlockStatements) {
        this.initialStatements = initialStatements;
        this.mainBlockStatements = mainBlockStatements;
    }

    public List<Statement> getInitialStatements() {
        return initialStatements;
    }

    public List<Statement> getMainBlockStatements() {
        return mainBlockStatements;
    }

    @Override
    public String toString() {
        return String.format(
                "Program:%s" +
                "initial statements: %d%s" +
                "main block statements: %d",
                "\n\t",
                this.initialStatements.size(), "\n\t",
                this.mainBlockStatements.size()
        );
    }
}
