package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.State.TurtleHistory;

public class Pi extends ArithmeticOp {

  public Pi() {
    super();
    myNumArgs = 0;
  }

  public double getRetVal(TurtleHistory history) {
    return Math.PI;
  }
}
