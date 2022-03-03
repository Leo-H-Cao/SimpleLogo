package slogo.Backend.SyntaxParser.Data;

import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Variable extends Operator {
  private double myValue;

  public Variable(int seqNum){
    super(seqNum);

  }
  public void setValue(int value){
    this.myValue = value;
  }

  public double getRetVal(LogoRuntimeState runtimeState){
    return myValue;
  }
}
