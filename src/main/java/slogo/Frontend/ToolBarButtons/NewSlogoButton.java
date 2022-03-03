package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import slogo.Main;

public class NewSlogoButton extends ToolBarButtonAbstract{

  public NewSlogoButton(String buttonName) {
    super(buttonName);
    myButton.setOnAction(actionEvent -> {
      //create new slogo instance
      Main.createNewSLogo();
    });
  }
}
