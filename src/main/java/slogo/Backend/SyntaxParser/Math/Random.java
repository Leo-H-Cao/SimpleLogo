package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Random extends ArithmeticOp {
  public Random() {
    myNumArgs = 1;
  }

  public Random(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return Math.random() * this.arguments.get(0).getRetVal(turtleStack);
  }
}
