package slogo.Backend.LexicalAnalyzer;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class ____
 * @author Alex
 */
public class RawTokenScanner {
  private static final RawTokenScanner RAW_TOKEN_SCANNER = new RawTokenScanner();
  private final HashMap<TokenType, Matcher> matchers;

  /** reference: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html */
  private RawTokenScanner() {
    this.matchers = new HashMap<>();
    ResourceBundle syntaxResource = ResourceBundle.getBundle("slogo/languages/Syntax");
    for (String typeOfToken : syntaxResource.keySet()) {
      String regexString = syntaxResource.getString(typeOfToken);
      Pattern pattern = Pattern.compile(regexString);
      Matcher matcher = pattern.matcher("");
      matchers.put(TokenType.valueOf(typeOfToken.toUpperCase(Locale.ROOT)), matcher);
    }
  }

  public static RawTokenScanner getTokenScanner() {
    return RAW_TOKEN_SCANNER;
  }

  private static String createInvalidTokenMessage(String badToken) {
    return "The token '" + badToken + "' is not recognized as valid";
  }

  public RawToken attemptMatch(String s) throws InvalidTokenException {
    for (TokenType tokenType : matchers.keySet()) {
      Matcher matcher = matchers.get(tokenType);
      matcher.reset(s);
      boolean matchStatus = matcher.matches();
      if (matchStatus) {
        return new RawToken(tokenType, s);
      }
    }
    //If the program makes it here that implies that the String s was an invalid token
    String exceptionMessage = RawTokenScanner.createInvalidTokenMessage(s);
    throw new InvalidTokenException(exceptionMessage);
  }
}
