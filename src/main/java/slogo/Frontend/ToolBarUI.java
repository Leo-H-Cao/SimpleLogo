package slogo.Frontend;

import javafx.scene.control.ToolBar;
import slogo.Frontend.ToolBarButtons.CommandHistoryToolbarButton;
import slogo.Frontend.ToolBarButtons.ToolBarButtonAbstract;

public class ToolBarUI {

  private ToolBar mytoolBar;
  private ToolBarButtonAbstract commandHistoryButton;

  public ToolBarUI(){
    mytoolBar = new ToolBar();
    mytoolBar.setId("ToolBar");
    createToolBar();
  }

  public ToolBar getToolBar(){
    return mytoolBar;
  }

  private void createToolBar(){
    commandHistoryButton = new CommandHistoryToolbarButton("Command History");
    commandHistoryButton.getButton().setId("CommandHistoryButton");
    mytoolBar.getItems().add(commandHistoryButton.getButton());
  }

}
