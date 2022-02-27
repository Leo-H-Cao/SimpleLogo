package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Power extends ArithmeticOp {

  public Power() {
    myNumArgs = 2;
  }

  public Power(Operator op1, Operator op2) {
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return Math.pow(this.arguments.get(0).getRetVal(turtleStack), this.arguments.get(1).getRetVal(turtleStack));
  }
}
