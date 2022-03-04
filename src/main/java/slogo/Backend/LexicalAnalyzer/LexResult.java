package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;

public class LexResult {

  private final ArrayDeque<String> splitByWhiteSpace;
  private ArrayDeque<RawToken> unevaluatedRawTokens;
  private ArrayDeque<RawToken> evaluatedTokens;


  public LexResult(String instruction) throws InvalidTokenException {
    this.splitByWhiteSpace = InstructionSplitter.splitInstruction(instruction);
    this.unevaluatedRawTokens = this.tokenize();
    this.evaluatedTokens = this.evaluateTokens();
  }

  private ArrayDeque<RawToken> evaluateTokens() {

  }

  private ArrayDeque<RawToken> tokenize() throws InvalidTokenException {
    ArrayDeque<RawToken> rawTokens = new ArrayDeque<>();
    for (String s : this.splitByWhiteSpace) {
      RawToken rawToken = TokenFactory.getRawToken(s);
      if (rawToken != null) {
        rawTokens.addLast(rawToken);
      } else {
        throw new InvalidTokenException(s + "is a bad RawToken");
        // TODO: implement error text and better error message
      }
    }
    return rawTokens;
  }

  public ArrayDeque<RawToken> getEvaluatedTokens() {
    return evaluatedTokens;
  }
}
