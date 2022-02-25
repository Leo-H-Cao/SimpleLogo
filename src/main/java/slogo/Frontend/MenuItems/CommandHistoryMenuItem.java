package slogo.Frontend.MenuItems;

import static slogo.Frontend.View.stage;

import slogo.Frontend.CommandHistoryPopup;

public class CommandHistoryMenuItem extends MenuItemAbstract {

  private CommandHistoryPopup popup;

  public CommandHistoryMenuItem(String itemName) {
    super(itemName);
    setupPopup();
  }

  private void setupPopup(){
    popup = new CommandHistoryPopup(null);
    menuItem.setOnAction(actionEvent -> {
      if (!popup.getPopup().isShowing())
        popup.getPopup().show(stage);
      else
        popup.getPopup().hide();
    });
  }

}
