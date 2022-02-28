package slogo.Backend.LexicalAnalyzer;

public class TokenFactory {
  private static final TokenScanner tokenScanner = TokenScanner.getTokenScanner();

  public static Token getToken(String s) throws InvalidTokenException {
    return tokenScanner.attemptMatch(s);
  }
}
