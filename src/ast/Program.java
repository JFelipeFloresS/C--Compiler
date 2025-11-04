package ast;

import ast.definitions.Definition;
import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode {

    private final List<Definition> definitions;

    public Program(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (Definition def : definitions) {
          sb.append(def.toString()).append("\n");
      }
        return String.format(
                "Program: %n\t" +
                "statements: %d%n\t" +
                "%s",
                this.definitions.size(),
                sb
        );
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
