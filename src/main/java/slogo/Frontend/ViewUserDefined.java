package slogo.Frontend;

import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;
import slogo.FrontendExternalAPIs.UpdateUserDefined;

public class ViewUserDefined implements UpdateUserDefined {

  /**
   * update user defined commands state
   *
   * @param commands
   */
  @Override
  public void updateUserCommands(UserCommands commands) {}

  /**
   * update user defined variables state
   *
   * @param variables
   */
  @Override
  public void updateVariables(UserVariables variables) {}
}
