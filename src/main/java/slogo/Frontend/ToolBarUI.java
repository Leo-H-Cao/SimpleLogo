package slogo.Frontend;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import slogo.Frontend.ToolBarButtons.CommandHistoryToolbarButton;
import slogo.Frontend.ToolBarButtons.LanguageSelect;
import slogo.Frontend.ToolBarButtons.SelectBackgroundColorButton;
import slogo.Frontend.ToolBarButtons.ToolBarButtonAbstract;
import slogo.Frontend.ToolBarButtons.TurtleImageChooserButton;

public class ToolBarUI {

  private ToolBar mytoolBar;
  private ToolBarButtonAbstract commandHistoryButton;
  private LanguageSelect languageSelect;
  private SelectBackgroundColorButton colorButton;
  private Pane buttonBarContainer;
  private TurtleImageChooserButton turtleImageButton;

  public ToolBarUI(TurtleView turtleView){
    buttonBarContainer = new HBox();
    buttonBarContainer.getStyleClass().add("tool-bar-container");
    mytoolBar = new ToolBar();
    mytoolBar.setId("ToolBar");
    mytoolBar.getStyleClass().add("tool-bar-ui");
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
    turtleImageButton = new TurtleImageChooserButton("Choose Turtle Image");

    buttonBarContainer.getChildren().addAll(commandHistoryButton.getButton(), languageSelect.getChoiceBox(),
        colorButton.getButton(), turtleImageButton.getButton());
    mytoolBar.getItems().addAll(buttonBarContainer);
  }

}
