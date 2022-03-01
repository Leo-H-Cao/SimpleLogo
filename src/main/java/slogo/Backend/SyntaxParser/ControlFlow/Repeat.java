package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Repeat extends Operator {
  public Repeat(int seqNum){
    super(seqNum);
  }
  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int numRepetitions = (int) arguments.get(0).getRetVal(history);
    for(int i=0; i<numRepetitions; i++){
      double retVal = arguments.get(1).getRetVal(history);
    }
    return retVal;
  }

}
