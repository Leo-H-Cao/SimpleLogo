package slogo.Backend.SyntaxParser.Data;

import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Variable extends Operator {
  private double myValue;
  private String myName;

  public Variable(int seqNum){
    super(seqNum);

  }
  public void setValue(int value){
    this.myValue = value;
  }

  public double getRetVal(LogoRuntimeState runtimeState){
    myValue = runtimeState.evaluateVariable(this.myName);
    return myValue;
  }

  public void setName(String name){
    myName = name;
  }
  public String getName(){
    return myName;
  }

}
