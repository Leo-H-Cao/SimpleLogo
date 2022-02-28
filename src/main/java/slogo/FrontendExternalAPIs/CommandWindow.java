package slogo.FrontendExternalAPIs;

import slogo.Backend.State.CommandHistory;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.TurtleHistory;

public interface CommandWindow {

  /**
   * Returns command input from user
   *
   * @return
   */
  String getCommands();

  /** gets command history from backend */
  void setCommandHistory(CommandHistory history);

  void setCommandLanguage(CommandLanguage lang);
}
