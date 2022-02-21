package slogo.FrontendExternalAPIs;

import slogo.Backend.CommandLanguage;
import slogo.Backend.History;

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
