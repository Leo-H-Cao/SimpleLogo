package slogo.Backend.SyntaxParser.Data;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Make extends Operator {

  public Make(int seqNum){
    super(seqNum);
  }

  public double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    return arguments.get(1).getRetVal(history);
  }

}
