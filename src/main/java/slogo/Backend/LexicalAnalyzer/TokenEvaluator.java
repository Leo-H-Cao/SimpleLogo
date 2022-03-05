package slogo.Backend.LexicalAnalyzer;

import dk.brics.automaton.RegExp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.Utilities;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.SpecialOperations;
/**
 * This class ____
 * @author Alex
 */
public class TokenEvaluator {
  private Map<String, String> evaluator;

  public TokenEvaluator(CommandLanguage commandLanguage) {
    Map<String, String> pairs = TokenEvaluator.getPairsFromCommandLanguage(commandLanguage); //rename pairs
    this.evaluator = computeMap(pairs);
  }

  private Map<String, String> computeMap(Map<String, String> pairs) {
    Map<String, String> map = new HashMap<>();
    for(String canonicalName: pairs.keySet()) {
      String regex = pairs.get(canonicalName);
      getStringsForCommand(canonicalName, regex, map);
    }
    return map;
  }

  private void getStringsForCommand(String canonicalName, String regex, Map<String, String> map) {
    Collection<String> allMatching = getMatchingStrings(regex);
    allMatching.add(canonicalName.toLowerCase());
    for(String matching: allMatching) {
      map.put(matching, canonicalName);
    }
  }

  private Collection<String> getMatchingStrings(String regex) {

    RegExp regExpCompiled = new RegExp(regex, RegExp.NONE);
    Automaton automaton = regExpCompiled.toAutomaton();
    return SpecialOperations.getFiniteStrings(automaton);
  }

  private static Map<String, String> getPairsFromCommandLanguage(CommandLanguage commandLanguage) {
    ResourceBundle commandResource = getResourceBundle(commandLanguage);
    Map<String, String> ret = new HashMap<>();
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
    return new Token(rawToken.getType(), value);
  }
}
