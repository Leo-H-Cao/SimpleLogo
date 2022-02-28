package slogo.Backend.State;

import java.util.ArrayList;

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

