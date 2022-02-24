package slogo.Frontend;

import javafx.scene.control.MenuBar;
import slogo.Frontend.MenuItems.CommandHistoryMenuItem;
import slogo.Frontend.MenuItems.HelpMenuItem;
import slogo.Frontend.MenuItems.MenuItemAbstract;

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
    MenuUI help = new MenuUI("Help");
    MenuItemAbstract helpItem = new HelpMenuItem("Reference Page");
    MenuUI commands = new MenuUI("Commands");
    MenuItemAbstract commandHistory = new CommandHistoryMenuItem("Command History");
    commands.addMenuItem(commandHistory);
    this.addToMenuBar(commands);
    help.addMenuItem(helpItem);
    this.addToMenuBar(help);
  }
}
