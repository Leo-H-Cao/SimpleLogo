package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class For extends Operator {

  public For(int sequenceNumber){
    super(sequenceNumber);
  }

  public double getRetVal(LogoRuntimeState s)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double start = arguments.get(0).getRetVal(s);
    double finish = arguments.get(0).getRetVal(s);
    double increment = arguments.get(2).getRetVal(s);

    double retVal = 0;
    for(double i=start; i<finish; i+=increment){
      retVal = arguments.get(3).getRetVal(s);
    }

    return retVal;
  }
}