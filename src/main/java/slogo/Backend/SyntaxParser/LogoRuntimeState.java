package slogo.Backend.SyntaxParser;

import java.util.ArrayDeque;
import java.util.HashMap;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.UserCommand;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.TurtleState.Turtle;
import slogo.SLogoController;

public class LogoRuntimeState {
  private TurtleHistory history;
  private HashMap<String, Double> variableTable;
  private HashMap<String, Operator> functionTable;

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
    if(!variableTable.keySet().contains(variable)){
      variableTable.put(variable, 0.0);
    }
    return variableTable.get(variable);
  }

  public void addFunction(String name, Operator func){
    functionTable.put(name, func);
  }

  public double evaluateFunction(String name, Operator arguments){
    functionTable.get(name);
    return 0;
  }

  public Operator getFunction(String name){
    return functionTable.get(name);
  }

}
