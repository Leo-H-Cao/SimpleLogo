package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Sine extends ArithmeticOp {

  public Sine() {
    myNumArgs = 1;
  }

  public Sine(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return Math.sin(this.arguments.get(0).getRetVal(turtleStack));
  }
}
