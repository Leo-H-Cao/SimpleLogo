package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class SquareRoot extends ArithmeticOp {

  public SquareRoot() {
    myNumArgs = 1;
  }

  public SquareRoot(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    double arg1 = this.arguments.get(0).getRetVal();
    if(arg1 < 0) {
      //TODO: Throw an error if input is negative
    }
    return Math.sqrt(arg1);
  }
}
