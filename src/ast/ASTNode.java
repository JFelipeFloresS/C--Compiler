package ast;

import visitor.Visitor;

public interface ASTNode {

  public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param);

}
