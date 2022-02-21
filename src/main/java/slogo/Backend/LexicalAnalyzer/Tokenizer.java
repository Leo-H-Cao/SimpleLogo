package slogo.Backend.LexicalAnalyzer;

public class Tokenizer {
  private static final TokenScanner tokenScanner = TokenScanner.getTokenScanner();

  public static Token getToken(String s) {
    return tokenScanner.attemptMatch(s);
  }
}
