package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import slogo.Frontend.ToolbarPopups.EditBackgroundColorPopup;

public class SelectBackgroundColorButton extends ToolBarButtonAbstract{

  private EditBackgroundColorPopup colorPopup;

  public SelectBackgroundColorButton(String buttonName){
    super(buttonName);
    myButton.setId("BackgroundColorButton");
    myButton.getStyleClass().add("select-background-button");
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
