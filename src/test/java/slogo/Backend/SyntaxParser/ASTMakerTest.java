package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.LexicalAnalyzer.TokenType;
import slogo.Backend.TurtleState.Turtle;

public class ASTMakerTest {

  private ASTMaker myASTMaker;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myTurtleStack = new ArrayDeque<Turtle>();
  }

  @Test
  void testParseConstant() {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.CONSTANT, "-1");
    a.add(t1);
    myASTMaker = new ASTMaker(a);
    assertEquals(-1, myASTMaker.parse().getRetVal());
  }

  @Test
  void testParseOneCommand() {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Difference");
    Token t2 = new Token(TokenType.CONSTANT, "100");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    myASTMaker = new ASTMaker(a);
    assertEquals(80, myASTMaker.parse().getRetVal());
  }
}
