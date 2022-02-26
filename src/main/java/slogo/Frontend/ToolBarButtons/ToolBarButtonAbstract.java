package slogo.Frontend.ToolBarButtons;

import javafx.scene.control.Button;

public class ToolBarButtonAbstract {

  protected Button myButton;

  public ToolBarButtonAbstract(String buttonName){
    myButton = new Button(buttonName);
  }

  public Button getButton() {
    return myButton;
  }
}
