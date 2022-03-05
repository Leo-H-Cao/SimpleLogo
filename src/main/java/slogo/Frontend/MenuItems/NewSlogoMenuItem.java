package slogo.Frontend.MenuItems;

import javafx.event.ActionEvent;

public class NewSlogoMenuItem extends MenuItemAbstract{

  public NewSlogoMenuItem(String itemName){
    super(itemName);
    menuItem.setOnAction(ActionEvent ->{
      //New slogo instance
    });
  }


}
