package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.TurtleState.Turtle;

public class Pi extends ArithmeticOp {

  public Pi() {
    super();
    myNumArgs = 0;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return Math.PI;
  }
}
