package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public abstract class ArithmeticOp extends Operator {

  public ArithmeticOp(int seqNum) {
    super(seqNum);
    //this.mySeqNum = seqNum;
  }

  public abstract double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

  public int getMyNumArgs() {
    return myNumArgs;
  }
}
