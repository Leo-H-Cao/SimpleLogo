package slogo.Backend.SyntaxParser.ControlFlow;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.Data.Variable;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class For extends Operator {

  public For(int sequenceNumber){
    super(sequenceNumber);
    myNumArgs = 2;
  }

  public double getRetVal(LogoRuntimeState s)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double start = arguments.get(0).getArguments().get(1).getRetVal(s);
    double finish = arguments.get(0).getArguments().get(2).getRetVal(s);
    double increment = arguments.get(0).getArguments().get(3).getRetVal(s);

    double retVal = 0;
    for(double i=start; i<finish; i+=increment){
      s.setVariableValue(((Variable)(arguments.get(0).getArguments().get(0))).getName(), arguments.get(0).getArguments().get(1).getRetVal(s));
      retVal = arguments.get(1).getRetVal(s);
    }

    return retVal;
  }
}