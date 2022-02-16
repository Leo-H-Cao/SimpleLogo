package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public abstract class Command {
  protected ArrayList<Command> arguments;
  protected double retVal;

  public abstract double getRetVal();

}
