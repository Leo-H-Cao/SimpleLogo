package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class If extends Operator {

  public If(int sequenceNumber){
    super(sequenceNumber);
  }

  public double getRetVal(LogoRuntimeState s)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = 0;
    if(arguments.get(0).getRetVal(s) != 0){
      retVal = arguments.get(1).getRetVal(s);
    }
    return retVal;
  }
}