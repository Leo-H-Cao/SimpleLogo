package slogo.Frontend;

import javafx.scene.control.Menu;

public class MenuUI {

  private Menu myMenu;

  public MenuUI(String menuName){
    myMenu = new Menu(menuName);
  }

  public void addMenuItem(MenuItemUI item){
    myMenu.getItems().add(item.getMenuItem());
  }

  public Menu getMenu(){
    return myMenu;
  }
}
