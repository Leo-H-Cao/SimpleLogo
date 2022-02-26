package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayList;
import slogo.Backend.SyntaxParser.Operator;

public abstract class ArithmeticOp extends Operator {

  public ArithmeticOp() {
    this.arguments = new ArrayList<Operator>();
  }


  public int getMyNumArgs() {
    return myNumArgs;
  }
}
