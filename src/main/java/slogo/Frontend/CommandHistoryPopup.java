package slogo.Frontend;

import javafx.scene.control.Label;
import javafx.stage.Popup;
import slogo.Backend.State.CommandHistory;

public class CommandHistoryPopup {

  private Popup myPopup;

  public CommandHistoryPopup(CommandHistory commandHistory){
    myPopup = new Popup();
    myPopup.setX(400);
    myPopup.setY(150);
    setLabel();
  }

  public Popup getPopup(){
    return myPopup;
  }

  private void setLabel(){
    Label label = new Label("Command History goes here");
    label.getStyleClass().add("command-history-popup-label");
    myPopup.getContent().add(label);
  }

}
