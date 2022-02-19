package slogo.FrontendExternalAPIs;

import slogo.Backend.CommandLanguage;
import slogo.Backend.History;

public abstract interface CommandWindow {

  /**
   * Returns command input from user
   * @return
   */
  public String getCommandInput();

  /**
   * gets command history from backend
   */
  public void setCommandHistory(History history);

  public void setCommandLanguage(CommandLanguage lang);

}
