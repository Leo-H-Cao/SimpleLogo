package slogo.Backend.SyntaxParser;

import slogo.Backend.State.TurtleHistory;

public class LogoList extends Operator{
  public LogoList(int seqNum){
    super(seqNum);
  }

  public double getRetVal(TurtleHistory history){
    return 0;
  }

}
