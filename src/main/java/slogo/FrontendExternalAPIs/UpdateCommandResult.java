package slogo.FrontendExternalAPIs;

import slogo.Backend.ErrorText;

public interface UpdateCommandResult {

  /**
   * show error if command is not valid
   *
   * @param error
   */
  void displayError(ErrorText error);
}
