package slogo.Backend.State;

import java.util.ArrayList;
/**
 * This class keeps track of user command history
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

