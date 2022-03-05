package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Repeat extends Operator {
  public Repeat(int seqNum){
    super(seqNum);
    myNumArgs = 2;
  }
  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    int numRepetitions = (int) arguments.get(0).getRetVal(runtimeState);
    for(int i=0; i<numRepetitions; i++){
      runtimeState.setVariableValue(":repcount", i+1);
      double retVal = arguments.get(1).getRetVal(runtimeState);
    }
    return retVal;
  }

}
