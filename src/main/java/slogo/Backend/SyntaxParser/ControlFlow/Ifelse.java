package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class Ifelse extends Operator {

  public Ifelse(int sequenceNumber){
    super(sequenceNumber);
    myNumArgs = 3;
  }

  public double getRetVal(LogoRuntimeState s)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = 0;
    if(arguments.get(0).getRetVal(s) != 0){
      retVal = arguments.get(1).getRetVal(s);
    }
    else{
      retVal = arguments.get(2).getRetVal(s);
    }
    return retVal;

  }
}
