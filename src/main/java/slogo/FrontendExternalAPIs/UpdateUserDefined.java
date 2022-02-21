package slogo.FrontendExternalAPIs;

import slogo.Backend.UserCommands;
import slogo.Backend.UserVariables;

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
