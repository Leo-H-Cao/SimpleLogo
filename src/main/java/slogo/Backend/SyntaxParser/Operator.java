package slogo.Backend.SyntaxParser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/***
 * The fundamental subunit of an instruction, including commands, constants, variables, and lists
 * @author Jed Yang
 */

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

  public abstract double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

  public int getMyNumArgs() {
    return myNumArgs;
  }

  public void addArgument(Operator o) {
    this.arguments.add(0,o);
  }

  public void appendArgument(Operator o) {
    this.arguments.add(o);
  }

  public void insertArgumentInOrder(Operator o){
    boolean added = false;
    for(int i=0; i<this.arguments.size(); i++){
      if(o.mySeqNum < this.arguments.get(i).mySeqNum){
        this.arguments.add(i,o);
        added = true;
        break;
      }
    }
    if(!added){
      this.arguments.add(o);
    }
  }

  public ArrayList<Operator> getArguments(){
    return arguments;
  }

  public void setSequenceNumber(int sequenceNumber){
    this.mySeqNum = sequenceNumber;
  }
}
