package slogo.Backend.SyntaxParser.TurtleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Towards extends Operator {

  public Towards(int seqNum){
    super(seqNum);
    myNumArgs = 2;
  }

  public Towards(Operator op1, Operator op2){
    super(0);
    arguments.add(op1);
    arguments.add(op2);
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = arguments.get(0).getRetVal(runtimeState);
    double retVal2 = arguments.get(1).getRetVal(runtimeState);
    ArrayList<Double> argList = new ArrayList<>();
    argList.add(retVal);
    argList.add(retVal2);
    runtimeState.getHistory().addTurtleThroughTransformation("Towards", argList);
    return retVal;
  }

}
