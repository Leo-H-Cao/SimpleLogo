package slogo.FrontendExternalAPIs;

import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;

public abstract interface UpdateUserDefined {

  /**
   * update user defined commands state
   * @param commands
   */
  public void updateUserCommands(UserCommands commands);

  /**
   * update user defined variables state
   * @param variables
   */
  public void updateVariables(UserVariables variables);

}
