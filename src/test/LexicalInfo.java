package test;

class LexicalInfo {
	
	private int line, column, tokenKey;
	
	private String lexeme;

	public Object semanticValue;
	
	public LexicalInfo(int line, int column, String lexeme, int tokenKey, Object semanticValue) {
		this.line = line;
		this.column = column;
		this.lexeme = lexeme;
		this.tokenKey = tokenKey;
		this.semanticValue = semanticValue;
	}
	
	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(line ").append(this.line)
			.append(", column ").append(this.column)
			.append(", lexeme '").append(this.lexeme).append("'")
			.append(", token key ").append(this.tokenKey)
			.append(", semantic value ").append(this.semanticValue)
			.append(")");
		return sb.toString();
	}
	
	public void assertLexicalEquals(int line, int column, String lexeme, int tokenKey, Object semanticValue) {
		if (this.line != line)
			throw new AssertionError("Assert failed in token " + this + ".\nExpected line " + this.line + ", obtained " + line + ".");
		if (this.column != column)
			throw new AssertionError("Assert failed in token " + this + ".\nExpected column " + this.column + ", obtained " + column + ".");
		if (!this.lexeme.equals(lexeme))
			throw new AssertionError("Assert failed in token " + this + ".\nExpected lexeme " + this.lexeme + ", obtained " + lexeme + ".");
		if (this.tokenKey != tokenKey)
			throw new AssertionError("Assert failed in token " + this + ".\nExpected token name " + this.tokenKey + ", obtained " + tokenKey + ".");
		if (!this.semanticValue.equals(semanticValue))
			throw new AssertionError("Assert failed in token " + this + ".\nExpected semanticValue " + this.semanticValue + ", obtained " + semanticValue + ".");
	}
}
