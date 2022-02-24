package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;

public class LexResult {

  private static final String WHITESPACEREGEX =
      "[\\s]+"; // source: https://www.baeldung.com/java-regex-s-splus
  private static final TokenScanner scanner = TokenScanner.getTokenScanner();
  private final String instruction;
  private final ArrayDeque<String> splitByWhiteSpace;
  private final ArrayDeque<Token> tokens;

  public LexResult(String instruction) throws InvalidTokenException {
    this.instruction = instruction;
    this.splitByWhiteSpace = this.splitInstruction();
    this.tokens = this.tokenize();
  }

  /**
   * Fix to be all white space
   *
   * @return Collection of Strings
   */
  protected ArrayDeque<String> splitInstruction() {
    String[] splitArray = this.instruction.trim().split(LexResult.WHITESPACEREGEX);
    ArrayDeque<String> deque = new ArrayDeque<>();
    for (String s : splitArray) {
      deque.addLast(s);
    }
    return deque;
  }

  protected ArrayDeque<Token> tokenize() throws InvalidTokenException {
    ArrayDeque<Token> tokens = new ArrayDeque<>();
    for (String s : this.splitByWhiteSpace) {
      Token token = Tokenizer.getToken(s);
      if (token != null) {
        tokens.addLast(token);
      } else {
        throw new InvalidTokenException(s + "is a bad Token");
        // TODO: implement error text and better error message
      }
    }
    return tokens;
  }

  public ArrayDeque<Token> getTokens() {
    return tokens;
  }
}
