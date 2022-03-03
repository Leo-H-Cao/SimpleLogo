package slogo.Backend.SyntaxParser.Math;

import slogo.Backend.SyntaxParser.LogoRuntimeState;

public class Pi extends ArithmeticOp {

  public Pi(int seqNum) {
    super(seqNum);
    myNumArgs = 0;
  }

  public double getRetVal(LogoRuntimeState runtimeState) {
    return Math.PI;
  }
}
