package slogo.Backend.SyntaxParser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import slogo.Backend.State.TurtleHistory;

public abstract class Operator {
  protected int myNumArgs;
  protected ArrayList<Operator> arguments;
  protected double retVal;
  protected int mySeqNum;

  //protected static TurtleHistory myHistory = new TurtleHistory();

  public Operator(int seqNum){
    this.arguments = new ArrayList<>();
    this.mySeqNum = seqNum;
    this.arguments = new ArrayList<Operator>();
  }

  public abstract double getRetVal(TurtleHistory history)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

  public int getMyNumArgs() {
    return myNumArgs;
  }

  public void addArgument(Operator o) {
    this.arguments.add(0,o);
  }

  public ArrayList<Operator> getArguments(){
    return arguments;
  }
}
