package slogo.Backend.LexicalAnalyzer;

public class Token {

  private final TokenType type;
  private final String value;

  public Token(TokenType type, String value) {
    this.type = type;
    this.value = value;
  }

  public TokenType getTyoe() {
    return type;
  }

  public String getValue() {
    return value;
  }

}
