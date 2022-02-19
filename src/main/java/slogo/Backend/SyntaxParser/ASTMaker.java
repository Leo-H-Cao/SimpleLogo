package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import slogo.Backend.LexicalAnalyzer.Token;

public class ASTMaker {
  private ArrayDeque<Token> tokens;
  private ArrayDeque<Operator> unevaluated;
  private ArrayDeque<Operator> evaluated;
  private Operator root;


  public ASTMaker(ArrayDeque<Token> tokens){
    this.tokens = tokens;
  }

  public Operator parse(){
    createArgumentStacks();
    generateAST();
    return root;
  }

  private void createArgumentStacks(){
    //TODO: create operands for all tokens and place them in the correct initial stack
  }

  private void generateAST(){
    //TODO: use the stacks of operands to generate the AST;
  }
}
