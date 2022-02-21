package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.LexicalAnalyzer.TokenType;

public class Main {

  public static void main(String[] args) {
    // write your code here
    ArithmeticOp op1 = new Difference(new Constant(10), new Constant(1));
    ArithmeticOp op2 = new Difference(new Constant(10), new Constant(1));
    ArithmeticOp root = new Sum(op1, op2);
    System.out.println(root.getRetVal());

    ArrayDeque<Token> a = new ArrayDeque<Token>();
    Token t1 = new Token(TokenType.COMMAND, "Sum");
    Token t2 = new Token(TokenType.CONSTANT, "10");
    Token t3 = new Token(TokenType.CONSTANT, "20");
    a.add(t1);
    a.add(t2);
    a.add(t3);
    ASTMaker astMaker = new ASTMaker(a);
    Operator parsedRoot = astMaker.parse();
    System.out.println(parsedRoot.getRetVal());
  }
}
