package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Logarithm extends ArithmeticOp {

  public Logarithm(int seqNum) {
    super(seqNum);
    myNumArgs = 1;
  }

  public Logarithm(Operator op1) {
    super(0);
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException {
    double arg1 = this.arguments.get(0).getRetVal(runtimeState);
    if(arg1 < 0) {
      throw new IllegalArgumentException("Argument for logarithm must be greater than 0");
    }
    return Math.log(arg1);
  }
}
