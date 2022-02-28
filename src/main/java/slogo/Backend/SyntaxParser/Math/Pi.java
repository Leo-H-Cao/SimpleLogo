package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.State.TurtleHistory;

public class Pi extends ArithmeticOp {

  public Pi(int seqNum) {
    super(seqNum);
    myNumArgs = 0;
  }

  public double getRetVal(TurtleHistory history) {
    return Math.PI;
  }
}
