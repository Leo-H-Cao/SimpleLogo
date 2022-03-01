package slogo.Frontend.ControlPanelButtons;


import javafx.scene.control.Button;

public class ControlPanelButtonAbstract {

  protected Button myButton;

  public ControlPanelButtonAbstract(String buttonName){
    myButton = new Button(buttonName);
    myButton.getStyleClass().add("control-panel-button");
  }

  public Button getButton() {
    return myButton;
  }

}
