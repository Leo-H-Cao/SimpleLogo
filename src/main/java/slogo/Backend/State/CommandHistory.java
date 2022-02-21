package slogo.Backend.State;

import java.util.ArrayList;

public class CommandHistory {
  private ArrayList<String> commandHist;
  private static CommandHistory commandHistory;

  private CommandHistory(){
    this.commandHist = new ArrayList<>();
  }

  private CommandHistory(ArrayList<String> commandHistory){
    this.commandHist = commandHistory;
  }

  public static CommandHistory getCommandHistory(){
    return CommandHistory.commandHistory;
  }

  public ArrayList<String> getCommandHist(){
    return this.commandHist;
  }

  public static CommandHistory initializeCommandHistory(ArrayList<String> commandHist){
    CommandHistory.commandHistory = new CommandHistory(commandHist);
    return CommandHistory.getCommandHistory();
  }

  public static CommandHistory initializeCommandHistory(){
    CommandHistory.commandHistory = new CommandHistory();
    return CommandHistory.getCommandHistory();
  }
}
