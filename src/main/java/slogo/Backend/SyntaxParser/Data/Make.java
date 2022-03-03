package slogo.Backend.SyntaxParser.Data;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Make extends Operator {

  public Make(int seqNum){
    super(seqNum);
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    Variable variable = (Variable) arguments.get(0);
    double value = arguments.get(1).getRetVal(runtimeState);
    runtimeState.setVariableValue(variable.getName(),value);
    return value;
  }

}
