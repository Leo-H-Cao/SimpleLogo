package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.Operator;

public class ArcTangent extends ArithmeticOp {

  public ArcTangent() {
    myNumArgs = 1;
  }

  public ArcTangent(Operator op1) {
    super();
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return Math.atan(this.arguments.get(0).getRetVal());
  }
}
