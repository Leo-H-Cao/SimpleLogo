package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Minus extends ArithmeticOp {
  public Minus() {
    myNumArgs = 1;
  }

  public Minus(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return -1 * this.arguments.get(0).getRetVal(turtleStack);
  }
}
