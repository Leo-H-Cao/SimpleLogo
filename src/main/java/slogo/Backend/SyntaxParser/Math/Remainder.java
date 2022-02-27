package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Math.ArithmeticOp;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Remainder extends ArithmeticOp {

  public Remainder() {
    myNumArgs = 2;
  }

  public Remainder(Operator op1, Operator op2) {
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return this.arguments.get(0).getRetVal(turtleStack) % this.arguments.get(1).getRetVal(turtleStack);
  }
}
