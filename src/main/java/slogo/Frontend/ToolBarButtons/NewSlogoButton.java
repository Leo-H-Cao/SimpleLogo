package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

public class NewSlogoButton extends ToolBarButtonAbstract{

  public NewSlogoButton(String buttonName) {
    super(buttonName);
    myButton.setOnAction(actionEvent -> {
      //create new slogo instance
    });
  }
}
