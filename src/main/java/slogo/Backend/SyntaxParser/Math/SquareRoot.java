package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class SquareRoot extends ArithmeticOp {

  public SquareRoot(int seqNum) {
    super(seqNum);
    myNumArgs = 1;
  }

  public SquareRoot(Operator op1) {
    super(0);
    this.arguments.add(op1);
    myNumArgs = 1;
  }

  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double arg1 = this.arguments.get(0).getRetVal(history);
    if(arg1 < 0) {
      //TODO: Throw an error if input is negative
    }
    return Math.sqrt(arg1);
  }
}
