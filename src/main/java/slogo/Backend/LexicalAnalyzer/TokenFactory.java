package slogo.Backend.LexicalAnalyzer;

import java.util.Map;
import slogo.Backend.State.CommandLanguage;

public class TokenFactory {
  private static final RawTokenScanner RAW_TOKEN_SCANNER = RawTokenScanner.getTokenScanner();
  private static Map<CommandLanguage, TokenEvaluator> tokenEvaluators;

  public static RawToken getRawToken(String s) throws InvalidTokenException {
    return RAW_TOKEN_SCANNER.attemptMatch(s);
  }

  public static Token getToken(RawToken rawToken, CommandLanguage commandLanguage) {
    if(!tokenEvaluators.containsKey(commandLanguage)) {
      tokenEvaluators.put(commandLanguage, new TokenEvaluator(commandLanguage));
    }
    return tokenEvaluators.get(commandLanguage).evaluateToken(rawToken);
  }
}
