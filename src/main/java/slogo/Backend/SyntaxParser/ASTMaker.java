package slogo.Backend.SyntaxParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    while(!tokens.isEmpty()){
      Token t = tokens.getFirst();
      String tokenType = t.getTyoe().toString();
      try {
        Class<?> operatorType = Class.forName("slogo.Backend.SyntaxParser." + tokenType);
        Constructor<?> constructor = operatorType.getConstructor();
        Operator nextOperator = (Operator) constructor.newInstance();
        if(tokenType.toString()=="Constant"){
          evaluated.addLast(nextOperator);
        }
        else{
          unevaluated.addLast(nextOperator);
        }
      } catch (ClassNotFoundException e) {
        //TODO: REPLACE THIS LATER
        //e.printStackTrace();
      } catch (NoSuchMethodException e) {
        //e.printStackTrace();
      } catch (InvocationTargetException e) {
        //e.printStackTrace();
      } catch (InstantiationException e) {
        //e.printStackTrace();
      } catch (IllegalAccessException e) {
        //e.printStackTrace();
      }
      tokens.removeFirst();
    }

  }

  private void generateAST(){
    //TODO: use the stacks of operands to generate the AST;
    while(!unevaluated.isEmpty()){
      Operator nextOperator = unevaluated.getLast();
      handleOperator(nextOperator);
    }
    root = evaluated.pop();
  }


  private void handleOperator(Operator operator){
    int numOperands = operator.getMyNumArgs();
    while(numOperands >0){
      operator.addArgument(evaluated.pop());
      numOperands--;
    }
    evaluated.addLast(operator);
  }
}
