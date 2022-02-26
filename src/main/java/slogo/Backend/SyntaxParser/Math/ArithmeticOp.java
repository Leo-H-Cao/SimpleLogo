package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public abstract class ArithmeticOp extends Operator {

  public ArithmeticOp() {
    this.arguments = new ArrayList<Operator>();
  }


  public int getMyNumArgs() {
    return myNumArgs;
  }
}
