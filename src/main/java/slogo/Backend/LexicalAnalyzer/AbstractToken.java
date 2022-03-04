package slogo.Backend.LexicalAnalyzer;

import java.util.Objects;

public abstract class AbstractToken {

  protected final TokenType type;
  protected final String value;

  public AbstractToken(TokenType type, String value) {
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
    RawToken rawToken = (RawToken) o;
    return type == rawToken.type && value.equals(rawToken.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }
}
