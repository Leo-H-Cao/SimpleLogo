package slogo.Backend.SyntaxParser.ControlFlow;

import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Operator;

public class Repeat extends Operator {
  public Repeat(int seqNum){
    super(seqNum);
  }
  public double getRetVal(TurtleHistory history){
    return 0;
  }

}
