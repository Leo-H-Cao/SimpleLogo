package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Random extends ArithmeticOp {
  public Random(int seqNum) {
    super(seqNum);
    myNumArgs = 1;
  }

  public Random(Operator op1) {
    super(0);
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return Math.random() * this.arguments.get(0).getRetVal(runtimeState);
  }
}
