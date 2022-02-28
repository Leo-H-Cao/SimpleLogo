package slogo.Frontend;

import javafx.scene.control.Menu;
import slogo.Frontend.MenuItems.MenuItemAbstract;

public class MenuUI {

  private final Menu myMenu;

  public MenuUI(String menuName) {
    myMenu = new Menu(menuName);
  }

  public void addMenuItem(MenuItemAbstract item) {
    myMenu.getItems().add(item.getMenuItem());
  }

  public Menu getMenu() {
    return myMenu;
  }
}
