package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public abstract class Operator {
  protected ArrayList<Operator> arguments;
  protected double retVal;

  public abstract double getRetVal();

}
