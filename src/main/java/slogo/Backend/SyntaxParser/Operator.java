package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import slogo.Backend.TurtleState.Turtle;

public abstract class Operator {
  protected int myNumArgs;
  protected ArrayList<Operator> arguments;
  protected double retVal;

  public abstract double getRetVal(ArrayDeque<Turtle> turtleStack);

  public int getMyNumArgs() {
    return myNumArgs;
  }

  public void addArgument(Operator o) {
    this.arguments.add(o);
  }
}
