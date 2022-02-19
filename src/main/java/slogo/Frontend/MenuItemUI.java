package slogo.Frontend;

import javafx.scene.control.MenuItem;

public class MenuItemUI {

  private MenuItem menuItem;

  public MenuItemUI(String itemName){
    menuItem = new MenuItem(itemName);
  }

  public MenuItem getMenuItem(){
    return menuItem;
  }
}
