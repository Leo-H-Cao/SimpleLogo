package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Random extends ArithmeticOp {
  public Random() {
    myNumArgs = 1;
  }

  public Random(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return Math.random() * this.arguments.get(0).getRetVal();
  }
}
