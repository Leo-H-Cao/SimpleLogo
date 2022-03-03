package slogo.Frontend;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import slogo.Backend.ErrorText;
import slogo.Backend.Result;
import slogo.FrontendExternalAPIs.UpdateCommandResult;

public class CommandOutput implements UpdateCommandResult {
  private Alert errorAlert;
  private TextArea output;

  public CommandOutput() {
    errorAlert = new Alert(AlertType.ERROR);
    output = new TextArea();
    output.setEditable(false);
    output.getStyleClass().add("command-output-text");
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

  @Override
  public void displayResult(Result result){
    output.setText(String.valueOf(result.getIntReturned()));
  }

  public TextArea getTextArea(){
    return output;
  }
}
