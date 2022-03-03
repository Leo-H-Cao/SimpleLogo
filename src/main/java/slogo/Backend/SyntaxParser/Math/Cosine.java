package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Cosine extends ArithmeticOp {

  public Cosine(int seqNum) {
    super(seqNum);
    myNumArgs = 1;
  }

  public Cosine(Operator op1) {
    super(0);
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return Math.cos(Math.toRadians(this.arguments.get(0).getRetVal(runtimeState)));
  }
}
