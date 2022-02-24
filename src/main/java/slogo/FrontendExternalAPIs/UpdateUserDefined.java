package slogo.FrontendExternalAPIs;

import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;

public interface UpdateUserDefined {

  /**
   * update user defined commands state
   *
   * @param commands
   */
  void updateUserCommands(UserCommands commands);

  /**
   * update user defined variables state
   *
   * @param variables
   */
  void updateVariables(UserVariables variables);
}
