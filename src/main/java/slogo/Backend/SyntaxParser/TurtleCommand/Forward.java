package slogo.Backend.SyntaxParser.TurtleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Forward extends Operator {

  public Forward(int seqNum){
    super(seqNum);
    myNumArgs = 1;
  }

  public Forward(Operator op1){
    super(0);
    arguments.add(op1);
  }

  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = arguments.get(0).getRetVal(history);
    ArrayList<Double> argList = new ArrayList<>();
    argList.add(retVal);
    history.addTurtleThroughTransformation("Forward", argList);
    return retVal;
  }

}
