package slogo.Backend.LexicalAnalyzer;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return type == token.type && value.equals(token.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }
}
