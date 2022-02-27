package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.SyntaxParser.Operator;

public abstract class ArithmeticOp extends Operator {

  public ArithmeticOp() {
    this.arguments = new ArrayList<Operator>();
  }

  public abstract double getRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

  public int getMyNumArgs() {
    return myNumArgs;
  }
}
