package slogo.Frontend;

import javafx.scene.control.ToolBar;
import slogo.Frontend.ToolBarButtons.CommandHistoryToolbarButton;
import slogo.Frontend.ToolBarButtons.LanguageSelect;
import slogo.Frontend.ToolBarButtons.SelectBackgroundColorButton;
import slogo.Frontend.ToolBarButtons.ToolBarButtonAbstract;

public class ToolBarUI {

  private ToolBar mytoolBar;
  private ToolBarButtonAbstract commandHistoryButton;
  private LanguageSelect languageSelect;
  private SelectBackgroundColorButton colorButton;

  public ToolBarUI(){
    mytoolBar = new ToolBar();
    mytoolBar.setId("ToolBar");
    createToolBar();
  }

  public ToolBar getToolBar(){
    return mytoolBar;
  }

  public String getDisplayLanguage(){
    return languageSelect.getChoiceBox().getSelectionModel().getSelectedItem().toString();
  }

  private void createToolBar(){
    commandHistoryButton = new CommandHistoryToolbarButton("Command History");
    commandHistoryButton.getButton().setId("CommandHistoryButton");
    languageSelect = new LanguageSelect("English");
    languageSelect.getChoiceBox().setId("SelectDisplayLanguage");
    colorButton = new SelectBackgroundColorButton("Change Background");

    mytoolBar.getItems().addAll(commandHistoryButton.getButton(), languageSelect.getChoiceBox(), colorButton.getButton());
  }

}
