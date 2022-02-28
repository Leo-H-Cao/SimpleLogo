package slogo.Backend.SyntaxParser.TurtleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Right extends Operator {

  public Right(int seqNum){
    super(seqNum);
    myNumArgs = 1;
  }

  public Right(Operator op1){
    super(0);
    arguments.add(op1);
  }

  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = arguments.get(0).getRetVal(history);
    ArrayList<Double> argList = new ArrayList<>();
    argList.add(retVal);
    history.addTurtleThroughTransformation("Right", argList);
    return retVal;
  }

}
