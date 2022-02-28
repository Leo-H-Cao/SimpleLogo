package slogo.Frontend;

import javafx.scene.control.MenuBar;

public class MenuBarUI {

  private final MenuBar myMenuBar;

  public MenuBarUI() {
    myMenuBar = new MenuBar();
    createMenuBar();
  }

  public void addToMenuBar(MenuUI menu) {
    myMenuBar.getMenus().add(menu.getMenu());
  }

  public MenuBar getMenuBar() {
    return myMenuBar;
  }

  public void createMenuBar() {
    MenuUI help = new MenuUI("Helps");
    MenuItemUI project = new MenuItemUI("Reference Page");
    MenuUI commands = new MenuUI("Commands");
    MenuItemUI commandHistory = new MenuItemUI("Command History");
    commands.addMenuItem(commandHistory);
    this.addToMenuBar(commands);
    help.addMenuItem(project);
    this.addToMenuBar(help);
  }
}
