package slogo.Backend.SyntaxParser.ListStructure;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class LogoList extends Operator {
  public LogoList(int seqNum){
    super(seqNum);
    this.arguments = new ArrayList<>();
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = 0;
    for(Operator o : this.arguments){
      retVal = o.getRetVal(runtimeState);
    }
    return retVal;
  }



}
