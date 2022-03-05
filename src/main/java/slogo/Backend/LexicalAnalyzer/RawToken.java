package slogo.Backend.LexicalAnalyzer;
/**
 * This class is for "raw" Tokens, as in Tokens which
 * have not yet been evaluated
 * @author Alex
 */
public class RawToken extends AbstractToken {

  public RawToken(TokenType type, String value) {
    super(type, value);
  }

}
