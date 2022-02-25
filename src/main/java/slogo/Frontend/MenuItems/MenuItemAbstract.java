package slogo.Frontend.MenuItems;

import javafx.scene.control.MenuItem;

public abstract class MenuItemAbstract {

  protected MenuItem menuItem;

  public MenuItemAbstract(String itemName) {
    menuItem = new MenuItem(itemName);
  }

  public MenuItem getMenuItem() {
    return menuItem;
  }

}
