package slogo.Frontend;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import slogo.Backend.ErrorText;
import slogo.FrontendExternalAPIs.UpdateCommandResult;

public class CommandOutput implements UpdateCommandResult {
  private Alert errorAlert;
  public CommandOutput() {
    errorAlert = new Alert(AlertType.ERROR);
  }

  /**
   * show error if command is not valid
   *
   * @param error
   */
  @Override
  public void displayError(ErrorText error) {
    errorAlert.setHeaderText("Input not valid");
    errorAlert.setContentText(error.getText());
    errorAlert.showAndWait();
  }
}
