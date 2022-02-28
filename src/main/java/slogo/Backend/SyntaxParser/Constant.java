package slogo.Backend.SyntaxParser;

import java.util.ArrayList;
import slogo.Backend.State.TurtleHistory;

public class Constant extends Operator {

  public Constant(int seqNum) {
    super(seqNum);
  }

  public Constant(int seqNum, double value) {
    super(seqNum);
    retVal = value;
    arguments = new ArrayList<>();
  }

  public double getRetVal(TurtleHistory history) {
    return retVal;
  }

  public int getMyNumArgs() {
    return 0;
  }

  public void addArgument(Operator o) {
    this.arguments.add(0, o);
  }
}
