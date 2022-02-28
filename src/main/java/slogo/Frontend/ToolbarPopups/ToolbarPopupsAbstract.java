package slogo.Frontend.ToolbarPopups;

import javafx.stage.Popup;

public abstract class ToolbarPopupsAbstract {
  Popup myPopup;

  public ToolbarPopupsAbstract(){
    myPopup = new Popup();
  }

  void setLocation(double x, double y){
    myPopup.setX(x);
    myPopup.setY(y);
  }

  public Popup getPopup(){
    return myPopup;
  }

   abstract void setLayout();

}
