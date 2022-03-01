package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.LexicalAnalyzer.TokenType;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.TurtleState.Turtle;

public class ASTMakerTest {

  private ASTMaker myASTMaker;
  private ArrayDeque<Turtle> myTurtleStack;
  private TurtleHistory myTurtleHistory;

  @BeforeEach
  void setup() {
    myTurtleStack = new ArrayDeque<Turtle>();
    myTurtleHistory = new TurtleHistory();
    ArrayDeque<Turtle> currentHistory = new ArrayDeque<>();
    currentHistory.addLast(new Turtle(new int[]{0, 0}, 0, true));
    myTurtleHistory.getTurtleHistory().addLast(currentHistory);
  }

  @Test
  void testParseConstant()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.CONSTANT, "-1");
    a.add(t1);
    myASTMaker = new ASTMaker(a);
    assertEquals(-1, myASTMaker.parse().arguments.get(0).getRetVal(new TurtleHistory()));
  }

  @Test
  void testParseOneCommand()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Difference");
    Token t2 = new Token(TokenType.CONSTANT, "100");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    myASTMaker = new ASTMaker(a);
    LogoList root = myASTMaker.parse();
    Operator o1 = root.arguments.get(0);
    assertEquals(80, o1.getRetVal(new TurtleHistory()));
  }

  @Test
  void testParseTwoSeparateCommands()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Difference");
    Token t2 = new Token(TokenType.CONSTANT, "100");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    Token t4 = new Token(TokenType.COMMAND, "Sum");
    Token t5 = new Token(TokenType.CONSTANT, "90");
    Token t6 = new Token(TokenType.CONSTANT, "5");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    a.add(t4);
    a.add(t5);
    a.add(t6);
    myASTMaker = new ASTMaker(a);
    LogoList root = myASTMaker.parse();
    Operator op1 = root.arguments.get(0);
    Operator op2 = root.arguments.get(1);
    //assertEquals(80, op1.getRetVal(new TurtleHistory()));
    assertEquals(95, op2.getRetVal(new TurtleHistory()));
  }


  @Test
  void testParseNestedCommands()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Forward");
    Token t2 = new Token(TokenType.COMMAND, "Sum");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    Token t4 = new Token(TokenType.CONSTANT, "50");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    a.add(t4);
    myASTMaker = new ASTMaker(a);
    LogoList root = myASTMaker.parse();
    Operator op1 = root.arguments.get(0);
    op1.getRetVal(myTurtleHistory);
    assertEquals(70, op1.getRetVal(myTurtleHistory));
  }

  @Test
  void testParseRepeatCommand()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Repeat");
    Token t2 = new Token(TokenType.CONSTANT, "2");
    Token t3 = new Token(TokenType.LISTSTART, "[");
    Token t4 = new Token(TokenType.COMMAND, "Forward");
    Token t5 = new Token(TokenType.CONSTANT, "10");
    Token t6 = new Token(TokenType.LISTEND, "]");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    a.add(t4);
    a.add(t5);
    a.add(t6);
    myASTMaker = new ASTMaker(a);
    LogoList root = myASTMaker.parse();
    assertEquals(2,root.arguments.get(0).arguments.get(0).getRetVal(new TurtleHistory()));

  }


  @Test
  void testSequenceNumber(){
    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Difference");
    Token t2 = new Token(TokenType.CONSTANT, "100");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    myASTMaker = new ASTMaker(a);
    LogoList root = myASTMaker.parse();
    assertEquals(0, root.arguments.get(0).mySeqNum);
    assertEquals(1, root.arguments.get(0).arguments.get(0).mySeqNum);
    assertEquals(2, root.arguments.get(0).arguments.get(1).mySeqNum);


  }
}
