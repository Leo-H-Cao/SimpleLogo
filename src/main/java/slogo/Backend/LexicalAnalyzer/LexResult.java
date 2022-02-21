package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class LexResult {

  private static final String WHITESPACEREGEX = "\\s+"; //source: https://www.baeldung.com/java-regex-s-splus
  private String instruction;
  private Deque<String> splitByWhiteSpace;
  private Deque<Token> tokens;
  private TokenScanner scanner = TokenScanner.getTokenScanner();

  public LexResult(String instruction) throws InvalidTokenException {
    this.instruction = instruction;
    this.splitByWhiteSpace = this.splitInstruction();
    this.tokens = this.tokenize();
  }

  /**
   * Fix to be all white space
   * @return Collection of Strings
   */
  protected Deque<String> splitInstruction()  {
    String[] splitArray = this.instruction.split(LexResult.WHITESPACEREGEX);
    ArrayDeque<String> deque = new ArrayDeque<>();
    for(String s: splitArray) {
      deque.addLast(s);
    }
    return deque;
  }
  
  protected Deque<Token> tokenize() throws InvalidTokenException {
    Deque<Token> tokens = new ArrayDeque<>();
    for(String s: this.splitByWhiteSpace)  {
      Token token = Tokenizer.getToken(s);
      if(token!=null) {
        tokens.addLast(token);
      }
      else  {
        throw new InvalidTokenException(s + "is a bad Token");
        //TODO: implement error text and better error message
      }
    }
    return tokens;
  }

}
