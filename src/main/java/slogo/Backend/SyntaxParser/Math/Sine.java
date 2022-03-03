package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Sine extends ArithmeticOp {

  public Sine(int seqNum) {
    super(seqNum);
    myNumArgs = 1;
  }

  public Sine(Operator op1) {
    super(0);
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return Math.sin(Math.toRadians(this.arguments.get(0).getRetVal(runtimeState)));
  }
}
