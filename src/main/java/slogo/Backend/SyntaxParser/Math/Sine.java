package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.Operator;

public class Sine extends ArithmeticOp {

  public Sine() {
    myNumArgs = 1;
  }

  public Sine(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return Math.sin(this.arguments.get(0).getRetVal());
  }
}
