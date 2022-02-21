package slogo.Frontend;

import javafx.scene.control.MenuItem;

public class MenuItemUI {

  private final MenuItem menuItem;

  public MenuItemUI(String itemName) {
    menuItem = new MenuItem(itemName);
  }

  public MenuItem getMenuItem() {
    return menuItem;
  }
}
