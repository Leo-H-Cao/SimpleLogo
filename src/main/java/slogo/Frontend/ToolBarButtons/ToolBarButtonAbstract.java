package slogo.Frontend.ToolBarButtons;

import javafx.scene.control.Button;

public class ToolBarButtonAbstract {

  protected Button myButton;

  public ToolBarButtonAbstract(String buttonName){
    myButton = new Button(buttonName);
    myButton.getStyleClass().add("tool-bar-button");
  }

  public Button getButton() {
    return myButton;
  }
}
