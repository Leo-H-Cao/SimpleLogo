package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Deque;
import slogo.Backend.State.CommandLanguage;
/**
 * This class ____
 * @author Alex
 */
public class LexResult {

  private final Deque<String> splitByWhiteSpace;
  private Deque<RawToken> unevaluatedRawTokens;
  private Deque<Token> evaluatedTokens;


  public LexResult(String instruction, CommandLanguage commandLanguage) throws InvalidTokenException {
    this.splitByWhiteSpace = InstructionSplitter.splitInstruction(instruction);
    this.unevaluatedRawTokens = this.tokenize();
    this.evaluatedTokens = this.evaluateTokens(commandLanguage);
  }

  private Deque<Token> evaluateTokens(CommandLanguage commandLanguage) {
    Deque<Token> ret = new ArrayDeque<>();
    for(RawToken rawToken: this.unevaluatedRawTokens) {
      ret.addLast(TokenFactory.getToken(rawToken, commandLanguage));
    }
    return ret;
  }

  private ArrayDeque<RawToken> tokenize() throws InvalidTokenException {
    ArrayDeque<RawToken> rawTokens = new ArrayDeque<>();
    for (String s : this.splitByWhiteSpace) {
      RawToken rawToken = TokenFactory.getRawToken(s);
      if (rawToken != null) {
        rawTokens.addLast(rawToken);
      } else {
        throw new InvalidTokenException(s + "is an invalid Token");
        // TODO: implement error text and better error message
      }
    }
    return rawTokens;
  }

  public Deque<Token> getEvaluatedTokens() {
    return evaluatedTokens;
  }
}
