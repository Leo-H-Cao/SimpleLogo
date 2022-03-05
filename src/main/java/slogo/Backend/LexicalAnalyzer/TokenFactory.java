package slogo.Backend.LexicalAnalyzer;

import java.util.HashMap;
import java.util.Map;
import slogo.Backend.State.CommandLanguage;
/**
 * This class ____
 * @author Alex
 */
public class TokenFactory {
  private static final RawTokenScanner RAW_TOKEN_SCANNER = RawTokenScanner.getTokenScanner();
  private static Map<CommandLanguage, TokenEvaluator> tokenEvaluators = new HashMap<>();

  public static RawToken getRawToken(String s) throws InvalidTokenException {
    return RAW_TOKEN_SCANNER.attemptMatch(s);
  }

  public static Token getToken(RawToken rawToken, CommandLanguage commandLanguage) {
    TokenFactory.createEvaluatorIfAbsent(commandLanguage);
    return tokenEvaluators.get(commandLanguage).evaluateToken(rawToken);
  }

  private static void createEvaluatorIfAbsent(CommandLanguage commandLanguage) {
    if(!tokenEvaluators.containsKey(commandLanguage)) {
      tokenEvaluators.put(commandLanguage, new TokenEvaluator(commandLanguage));
    }
  }
}
