package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class RandomRange extends ArithmeticOp {
  public RandomRange(int seqNum) {
    super(seqNum);
    myNumArgs = 2;
  }

  public RandomRange(Operator op1, Operator op2) {
    super(0);
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException {
    // TODO: Check to make sure max >= min
    double min = this.arguments.get(0).getRetVal(runtimeState);
    double max = this.arguments.get(1).getRetVal(runtimeState);
    if(max < min) throw new IllegalArgumentException("RandomRange max must be greater than or equal to min");
    return (Math.random() * (max - min)) + min;
  }
}
