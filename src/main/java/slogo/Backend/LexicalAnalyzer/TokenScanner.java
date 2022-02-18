package slogo.Backend.LexicalAnalyzer;

import java.util.HashMap;
import java.util.ResourceBundle;

public class TokenScanner {
  private static TokenScanner tokenScanner = new TokenScanner();

  private TokenScanner()  {
    HashMap<TokenType, TokenTypeRegex> typeToRegex;

    ResourceBundle syntaxResource = ResourceBundle.getBundle("slogo/languages/Syntax");
    syntaxResource;
  }

  public static TokenScanner getTokenScanner() {
    return tokenScanner;
  }
}
