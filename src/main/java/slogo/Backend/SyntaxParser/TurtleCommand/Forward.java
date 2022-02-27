package slogo.Backend.SyntaxParser.TurtleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.SyntaxParser.Operator;

public class Forward extends Operator {

  public Forward(){
    myNumArgs = 1;
  }

  public Forward(Operator op1){
    super();
    arguments.add(op1);
  }

  public double getRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = arguments.get(0).getRetVal();
    ArrayList<Double> argList = new ArrayList();
    argList.add(retVal);
    myHistory.addTurtleThroughTransformation("Forward", argList);
    return retVal;
  }

}
