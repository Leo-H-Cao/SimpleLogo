package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Remainder extends ArithmeticOp {

  public Remainder(int seqNum) {
    super(seqNum);
    myNumArgs = 2;
  }

  public Remainder(Operator op1, Operator op2) {
    super(0);
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return this.arguments.get(0).getRetVal(runtimeState) % this.arguments.get(1).getRetVal(
        runtimeState);
  }
}
