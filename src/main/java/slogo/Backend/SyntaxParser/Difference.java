package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import slogo.Backend.TurtleState.Turtle;

public class Difference extends ArithmeticOp {

  public Difference() {
    myNumArgs = 2;
  }

  public Difference(Operator op1, Operator op2) {
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return this.arguments.get(0).getRetVal(turtleStack) - this.arguments.get(1).getRetVal(turtleStack);
  }
}
