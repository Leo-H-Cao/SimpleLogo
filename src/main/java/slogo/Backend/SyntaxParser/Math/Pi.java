package slogo.Backend.SyntaxParser.Math;

public class Pi extends ArithmeticOp {

  public Pi() {
    super();
    myNumArgs = 0;
  }

  public double getRetVal() {
    return Math.PI;
  }
}
