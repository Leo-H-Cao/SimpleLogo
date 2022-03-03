package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import java.util.HashMap;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.TurtleState.Turtle;
import slogo.SLogoController;

public class LogoRuntimeState {
  private TurtleHistory history;
  private HashMap<String, Double> variableTable;
  private HashMap<Operator, LogoList> functionTable;

  public LogoRuntimeState(){
    Turtle turtle = SLogoController.INITIAL_TURTLE;
    this.history = new TurtleHistory();
    ArrayDeque<Turtle> currentHistory = new ArrayDeque<>();
    currentHistory.add(turtle);
    this.history.getTurtleHistory().add(currentHistory);
    currentHistory.addLast(turtle);

    this.variableTable = new HashMap<>();
    this.functionTable = new HashMap<>();
  }

  public TurtleHistory getHistory(){
    return history;
  }

  public void setVariableValue(String variable, double value){
    variableTable.put(variable, value);
  }

  public double evaluateVariable(String variable){
    return variableTable.get(variable);
  }


}
