package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.Operator;

public class Quotient extends ArithmeticOp {

  public Quotient() {
    myNumArgs = 2;
  }

  public Quotient(Operator op1, Operator op2) {
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal() {
    return this.arguments.get(0).getRetVal() / this.arguments.get(1).getRetVal();
  }
}
