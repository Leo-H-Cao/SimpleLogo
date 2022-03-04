package slogo.Backend.LexicalAnalyzer;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.ResourceBundle;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.Utilities;

public class TokenEvaluator {
  private HashMap<String, String> evaluator;

  public TokenEvaluator(CommandLanguage commandLanguage) {
    HashMap<String, String> pairs = TokenEvaluator.getPairsFromCommandLanguage(commandLanguage); //rename pairs
    computeMap(pairs);
  }

  private void computeMap(HashMap<String, String> pairs) {
    for(String canonicalName: pairs.keySet()) {
      String regex = pairs.get(canonicalName);
      addStringsForCommand(pairs, canonicalName, regex);
    }
  }

  private void addStringsForCommand(HashMap<String, String> pairs, String canonicalName, String regex) {
    Generex generex = new Generex(regex);
    Collection<String> allMatching = generex.getAllMatchedStrings();
    for(String matching: allMatching) {
      pairs.put(matching, canonicalName);
    }
  }

  private static HashMap<String, String> getPairsFromCommandLanguage(CommandLanguage commandLanguage) {
    ResourceBundle commandResource = getResourceBundle(commandLanguage);
    HashMap<String, String> ret = new HashMap<>();
    for(String key: commandResource.keySet()) {
      ret.put(key, commandResource.getString(key));
    }
    return ret;
  }

  private static ResourceBundle getResourceBundle(CommandLanguage commandLanguage) {
    String commandLanguageName = Utilities.getTitleCaseOf(commandLanguage.name());
    ResourceBundle commandResource = ResourceBundle.getBundle("slogo/languages/" + commandLanguageName);
    return commandResource;
  }

  public Token evaluateToken(RawToken rawToken) {
    String unevaluated = rawToken.getValue();
    String value = evaluator.getOrDefault(unevaluated.toLowerCase(), unevaluated);
    return new Token(rawToken.getTyoe(), value);
  }
}
