package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public class Constant extends Operator {

  public Constant() {}

  public Constant(double value) {
    retVal = value;
    arguments = new ArrayList<>();
  }

  public double getRetVal() {
    return retVal;
  }

  public int getMyNumArgs() {
    return 0;
  }

  public void addArgument(Operator o) {
    this.arguments.add(0, o);
  }
}
