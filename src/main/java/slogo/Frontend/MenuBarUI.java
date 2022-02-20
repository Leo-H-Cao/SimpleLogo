package slogo.Frontend;

import javafx.scene.control.MenuBar;

public class MenuBarUI {

  private MenuBar myMenuBar;

  public MenuBarUI(){
    myMenuBar = new MenuBar();
    createMenuBar();
  }

  public void addToMenuBar(MenuUI menu){
    myMenuBar.getMenus().add(menu.getMenu());
  }

  public MenuBar getMenuBar(){
    return myMenuBar;
  }

  public void createMenuBar(){
    MenuUI help = new MenuUI("Help");
    MenuItemUI project = new MenuItemUI("Reference Page");
    help.addMenuItem(project);
    this.addToMenuBar(help);


  }
}