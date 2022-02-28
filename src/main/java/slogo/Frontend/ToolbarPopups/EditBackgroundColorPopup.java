package slogo.Frontend.ToolbarPopups;

import static slogo.Frontend.View.stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import slogo.Frontend.TurtleBackground;

public class EditBackgroundColorPopup extends ToolbarPopupsAbstract {
  private static final String DEFAULT_COLOR_HEX = "#f0f8ff";

  private TextField colorField;
  private Label colorLabel;
  private HBox textFieldLayout;
  private Button submitButton;
  private VBox layout;
  private Label errorLabel;
  private String enteredColor;

  public EditBackgroundColorPopup(){
    super();
    colorField = new TextField(DEFAULT_COLOR_HEX);
    colorLabel = new Label("Color (hex): ");
    errorLabel = new Label("");
    submitButton = new Button("submit");
    createSubmitButton();
    setLayout();
  }

  @Override
  void setLayout(){
    textFieldLayout = new HBox();
    layout = new VBox();
    layout.getStyleClass().add("background-color-popup");
    textFieldLayout.getChildren().addAll(colorLabel, colorField, submitButton);
    layout.getChildren().addAll(textFieldLayout, errorLabel);
    myPopup.getContent().add(layout);
  }

  private void createSubmitButton(){
    submitButton = new Button("submit");
    submitButton.setOnAction(actionEvent -> {
      if ((colorField.getText() == null || colorField.getText().isEmpty())) {
        errorLabel.setText("You have not entered a color.");
      } else if(!validateHex(colorField.getText().trim())){
        errorLabel.setText("Invalid hex representation");
      }
      else {
        enteredColor = colorField.getText();
        myPopup.hide();
      }
    });
  }

  private boolean validateHex(String entry){
    String pattern = "^#(?:[0-9a-fA-F]{3}){1,2}$";
    Pattern hex = Pattern.compile(pattern);
    Matcher matcher = hex.matcher(entry);
    return matcher.find();
  }

}
