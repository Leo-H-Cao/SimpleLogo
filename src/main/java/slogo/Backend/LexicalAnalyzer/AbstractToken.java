package slogo.Backend.LexicalAnalyzer;

import java.util.Objects;

/**
 * This class ____
 * @author Alex
 */
public abstract class AbstractToken {

  protected final TokenType type;
  protected final String value;

  public AbstractToken(TokenType type, String value) {
    this.type = type;
    this.value = value;
  }

  public TokenType getType() {
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
    AbstractToken token = (AbstractToken) o;
    return type == token.type && value.equals(token.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }

  @Override
  public String toString(){
    return "Type: " + this.type + "\n" + "Value: " + this.value;
  }
}
