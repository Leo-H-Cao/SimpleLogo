package slogo.Backend.SyntaxParser.TurtleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class PenDown extends Operator {

  public PenDown(int seqNum){
    super(seqNum);
    myNumArgs = 0;
  }

  public PenDown(Operator op1){
    super(0);
    arguments.add(op1);
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ArrayList<Double> argList = new ArrayList<>();
    argList.add(retVal);
    runtimeState.getHistory().addTurtleThroughTransformation("Pendown", argList);
    return retVal;
  }

}
