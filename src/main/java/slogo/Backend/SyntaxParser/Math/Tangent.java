package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Tangent extends ArithmeticOp {

  public Tangent() {
    myNumArgs = 1;
  }

  public Tangent(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return Math.tan(this.arguments.get(0).getRetVal());
  }
}
