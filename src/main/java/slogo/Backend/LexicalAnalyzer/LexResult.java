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

  public LexResult(String instruction) {
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
  
  protected Deque<Token> tokenize() {
    Deque<Token> tokens = new ArrayDeque<>();
    Iterator<String> iter = splitByWhiteSpace.iterator();
    while(iter.hasNext())  {
      try {
        Token token = Tokenizer.getToken(iter.next());
        if(token!=null) {
          tokens.addLast(token);
        }
        else  {
          throw new InvalidTokenException();
        }
      }
      catch (InvalidTokenException e) {
        //implement
      }
    }
    return tokens;
  }

}
