package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Product extends ArithmeticOp {

  public Product(int seqNum) {
    super(seqNum);
    myNumArgs = 2;
  }

  public Product(Operator op1, Operator op2) {
    super(0);
    this.arguments.add(op1);
    this.arguments.add(op2);
    myNumArgs = 2;
  }

  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return this.arguments.get(0).getRetVal(history) * this.arguments.get(1).getRetVal(history);
  }
}
