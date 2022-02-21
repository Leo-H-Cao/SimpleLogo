package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenScanner {
  private HashMap<TokenType, Matcher> matchers;
  private static TokenScanner tokenScanner = new TokenScanner();

  /**
   * reference: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
   */
  private TokenScanner()  {
    this.matchers = new HashMap<>();
    ResourceBundle syntaxResource = ResourceBundle.getBundle("slogo/languages/Syntax");
    for(String typeOfToken : syntaxResource.keySet()) {
      String regexString = syntaxResource.getString(typeOfToken);
      Pattern pattern = Pattern.compile(regexString);
      Matcher matcher = pattern.matcher("");
      matchers.put(TokenType.valueOf(typeOfToken), matcher);
    }
  }

  public static TokenScanner getTokenScanner() {
    return tokenScanner;
  }

  public Token attemptMatch(String s) {
    for(TokenType tokenType: matchers.keySet())  {
      Matcher matcher = matchers.get(tokenType);
      matcher.reset(s);
      Boolean matchStatus = matcher.matches();
      if(matchStatus) {
        return new Token(tokenType, s);
      }
      else {
        throw InvalidTokenException.;
      }
    }
  }
}
