package slogo.Backend.SyntaxParser;

import java.util.ArrayList;
import slogo.Backend.State.TurtleHistory;

public class ListStart extends Operator {
  public ListStart(int seqNum){
    super(seqNum);
    this.arguments = new ArrayList<>();
  }

  public double getRetVal(TurtleHistory history){
    return 0;
  }

}
