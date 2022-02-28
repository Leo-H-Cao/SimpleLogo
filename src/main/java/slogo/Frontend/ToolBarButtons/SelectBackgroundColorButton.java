package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import slogo.Frontend.ToolbarPopups.EditBackgroundColorPopup;

public class SelectBackgroundColorButton extends ToolBarButtonAbstract{

  private EditBackgroundColorPopup colorPopup;

  public SelectBackgroundColorButton(String buttonName){
    super(buttonName);
    myButton.setId("BackgroundColorButton");
    setUpPopup();
  }

  private void setUpPopup(){
    colorPopup = new EditBackgroundColorPopup();
    myButton.setOnAction(actionEvent -> {
      if (!colorPopup.getPopup().isShowing()){
        colorPopup.getPopup().show(stage);
      }
      else
        colorPopup.getPopup().hide();
    });
  }

}
