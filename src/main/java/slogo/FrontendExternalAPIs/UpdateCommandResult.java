package slogo.FrontendExternalAPIs;

import slogo.Backend.ErrorText;

public abstract interface UpdateCommandResult {

  /**
   * show error if command is not valid
   * @param error
   */
  public void displayError(ErrorText error);

}
