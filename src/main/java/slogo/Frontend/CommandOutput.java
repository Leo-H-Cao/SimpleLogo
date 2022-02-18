package slogo.Frontend;

import slogo.Backend.ErrorText;
import slogo.FrontendExternalAPIs.UpdateCommandResult;

public class CommandOutput implements UpdateCommandResult {

  /**
   * show error if command is not valid
   * @param error
   */
  @Override
  public void displayError(ErrorText error){

  }

}
