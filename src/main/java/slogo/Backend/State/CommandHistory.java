package slogo.Backend.State;

import java.util.ArrayList;

public class CommandHistory {
  private static CommandHistory commandHistory;
  private final ArrayList<String> commandHist;

  private CommandHistory() {
    this.commandHist = new ArrayList<>();
  }

  private CommandHistory(ArrayList<String> commandHistory) {
    this.commandHist = commandHistory;
  }

  public static CommandHistory getCommandHistory() {
    return CommandHistory.commandHistory;
  }

  public static CommandHistory initializeCommandHistory(ArrayList<String> commandHist) {
    CommandHistory.commandHistory = new CommandHistory(commandHist);
    return CommandHistory.getCommandHistory();
  }

  public static CommandHistory initializeCommandHistory() {
    CommandHistory.commandHistory = new CommandHistory();
    return CommandHistory.getCommandHistory();
  }

  public ArrayList<String> getCommandHist() {
    return this.commandHist;
  }
}
