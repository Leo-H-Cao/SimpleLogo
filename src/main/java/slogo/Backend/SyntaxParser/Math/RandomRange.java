package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class RandomRange extends ArithmeticOp {
  public RandomRange() {
    myNumArgs = 2;
  }

  public RandomRange(Operator op1, Operator op2) {
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    // TODO: Check to make sure max >= min
    double min = this.arguments.get(0).getRetVal(turtleStack);
    double max = this.arguments.get(1).getRetVal(turtleStack);
    return (Math.random() * (max - min)) + min;
  }
}
