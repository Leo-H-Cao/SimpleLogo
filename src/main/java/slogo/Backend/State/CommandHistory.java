package slogo.Backend.State;

import java.util.ArrayList;
/**
 * This class ____
 * @author Alex
 */
public class CommandHistory {
  private ArrayList<String> commandHistory;

  public CommandHistory() {
    this.commandHistory = new ArrayList<>();
  }

  public CommandHistory(ArrayList<String> commandHistory) {
    this.commandHistory = commandHistory;
  }

  public ArrayList<String> getCommandHistoryList(){
    return this.commandHistory;
  }
}

