package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public abstract class Operator {
  protected int myNumArgs;
  protected ArrayList<Operator> arguments;
  protected double retVal;

  public abstract double getRetVal();

  public int getMyNumArgs() {
    return myNumArgs;
  }

  public void addArgument(Operator o) {
    this.arguments.add(o);
  }
}
