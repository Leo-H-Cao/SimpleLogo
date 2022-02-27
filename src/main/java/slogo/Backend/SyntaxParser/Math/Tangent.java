package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Tangent extends ArithmeticOp {

  public Tangent() {
    myNumArgs = 1;
  }

  public Tangent(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return Math.tan(this.arguments.get(0).getRetVal(turtleStack));
  }
}
