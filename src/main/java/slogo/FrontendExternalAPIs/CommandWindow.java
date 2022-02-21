package slogo.FrontendExternalAPIs;

import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.History;

public abstract interface CommandWindow {

  /**
   * Returns command input from user
   * @return
   */
  public String getCommands();

  /**
   * gets command history from backend
   */
  public void setCommandHistory(History history);

  public void setCommandLanguage(CommandLanguage lang);

}
