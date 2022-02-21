package slogo.Frontend;

import javafx.scene.control.TextField;
import slogo.Backend.ErrorText;
import slogo.FrontendExternalAPIs.UpdateCommandResult;

public class CommandOutput implements UpdateCommandResult {
  public CommandOutput() {
    TextField commands = new TextField();
  }
  /**
   * show error if command is not valid
   *
   * @param error
   */
  @Override
  public void displayError(ErrorText error) {}
}
