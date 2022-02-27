package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Minus extends ArithmeticOp {
  public Minus() {
    myNumArgs = 1;
  }

  public Minus(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return -1 * this.arguments.get(0).getRetVal();
  }
}
