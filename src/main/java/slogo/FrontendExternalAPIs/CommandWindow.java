package slogo.FrontendExternalAPIs;

import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.History;

public interface CommandWindow {

  /**
   * Returns command input from user
   *
   * @return
   */
  String getCommands();

  /** gets command history from backend */
  void setCommandHistory(History history);

  void setCommandLanguage(CommandLanguage lang);
}
