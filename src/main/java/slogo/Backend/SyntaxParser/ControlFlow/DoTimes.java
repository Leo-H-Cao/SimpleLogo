package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;



public class DoTimes extends Operator {

  public DoTimes(int sequenceNumber){
    super(sequenceNumber);
    myNumArgs = 2;
  }

  public double getRetVal(LogoRuntimeState s)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double doTimes = arguments.get(0).getRetVal(s);

    double retVal = 0;
    for(int i=0; i<doTimes; i++){
      retVal = arguments.get(1).getRetVal(s);
    }
    return retVal;
  }
}
