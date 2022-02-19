package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

import java.util.ArrayList;

public abstract class ArithmeticOp extends Operator {
  private int ArgNum;

  public ArithmeticOp(){
    this.arguments = new ArrayList<Operator>();
  }

  public abstract double getRetVal();
}
