package slogo.FrontendExternalAPIs;

import slogo.Backend.ErrorText;
import slogo.Backend.Result;

public interface UpdateCommandResult {

  /**
   * show error if command is not valid
   *
   * @param error
   */
  void displayError(ErrorText error);

  void displayResult(Result result);
}
