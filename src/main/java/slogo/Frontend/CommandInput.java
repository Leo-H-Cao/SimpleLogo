package slogo.Frontend;

import slogo.Backend.CommandLanguage;
import slogo.Backend.History;
import slogo.FrontendExternalAPIs.CommandWindow;

public class CommandInput implements CommandWindow {

  /**
   * Returns command input from user
   * @return
   */
  @Override
  public String getCommandInput(){
    return "";
  }

  /**
   * gets command history from backend
   */
  @Override
  public void setCommandHistory(History history){

  }

  @Override
  public void setCommandLanguage(CommandLanguage lang){

  }

}
