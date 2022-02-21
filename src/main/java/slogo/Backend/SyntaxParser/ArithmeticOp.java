package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

import java.util.ArrayList;

public abstract class ArithmeticOp extends Operator {
  protected int ArgNum;

  public ArithmeticOp(){
    this.arguments = new ArrayList<>();
  }

  public abstract double getRetVal();
  public int getMyNumArgs(){
    return ArgNum;
  }
}
