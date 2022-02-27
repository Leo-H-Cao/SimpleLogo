package slogo.Backend.SyntaxParser.Math;

import java.util.ArrayDeque;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;

public class Logarithm extends ArithmeticOp {

  public Logarithm() {
    myNumArgs = 1;
  }

  public Logarithm(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    double arg1 = this.arguments.get(0).getRetVal(turtleStack);
    if(arg1 < 0) {
      //TODO: Throw an error if input is negative or zero
    }
    return Math.log(arg1);
  }
}
