package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class LexResult {

  private String instruction;
  private Deque<String> splitByWhiteSpace;
  private Deque<Token> tokens;
  private TokenScanner scanner = TokenScanner.getTokenScanner();

  public LexResult(String instruction) {
    this.instruction = instruction;
    this.splitByWhiteSpace = this.splitInstruction();
    this.tokens = this.tokenize();
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

  /**
   * Fix to be all white space
   * @return
   */
  protected Deque<String> splitInstruction()  {
    String[] s = this.instruction.split(" ");
    return new ArrayDeque<String>(List.of(s)); //reverse before adding
  }
}
