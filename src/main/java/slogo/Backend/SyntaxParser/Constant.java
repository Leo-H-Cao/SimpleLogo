package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import slogo.Backend.TurtleState.Turtle;

public class Constant extends Operator {

  public Constant() {}

  public Constant(double value) {
    retVal = value;
    arguments = new ArrayList<>();
  }

  public double getRetVal(ArrayDeque<Turtle> turtleStack) {
    return retVal;
  }

  public int getMyNumArgs() {
    return 0;
  }

  public void addArgument(Operator o) {
    this.arguments.add(0, o);
  }
}
