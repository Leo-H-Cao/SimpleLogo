package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class ArcTangent extends ArithmeticOp {

  public ArcTangent() {
    myNumArgs = 1;
  }

  public ArcTangent(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return Math.atan(this.arguments.get(0).getRetVal());
  }
}
