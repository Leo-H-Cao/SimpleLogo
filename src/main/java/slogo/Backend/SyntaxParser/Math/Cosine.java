package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Cosine extends ArithmeticOp {

  public Cosine() {
    myNumArgs = 1;
  }

  public Cosine(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal() {
    return Math.cos(this.arguments.get(0).getRetVal());
  }
}
