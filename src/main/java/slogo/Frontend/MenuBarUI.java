package slogo.Frontend;

import javafx.scene.control.MenuBar;
import slogo.Frontend.MenuItems.HelpMenuItem;
import slogo.Frontend.MenuItems.MenuItemAbstract;
import slogo.Frontend.MenuItems.NewSlogoMenuItem;

public class MenuBarUI {

  private final MenuBar myMenuBar;

  /**
   * MenuBar at top of application
   * @author Leo Cao
   */
  public MenuBarUI() {
    myMenuBar = new MenuBar();
    myMenuBar.setId("MenuBar");
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
    MenuUI file = new MenuUI("File");
    MenuItemAbstract helpItem = new HelpMenuItem("Reference Page");
    MenuItemAbstract fileItem = new NewSlogoMenuItem("New Slogo");
    help.addMenuItem(helpItem);
    file.addMenuItem(fileItem);
    this.addToMenuBar(file);
    this.addToMenuBar(help);
  }
}
