package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Sine extends ArithmeticOp {

  public Sine() {
    myNumArgs = 1;
  }

  public Sine(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return Math.sin(this.arguments.get(0).getRetVal());
  }
}
