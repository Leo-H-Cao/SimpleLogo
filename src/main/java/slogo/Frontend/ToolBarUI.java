package slogo.Frontend;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import slogo.Frontend.ToolBarButtons.BackgroundColorPicker;
import slogo.Frontend.ToolBarButtons.CommandHistoryToolbarButton;
import slogo.Frontend.ToolBarButtons.LanguageSelect;
import slogo.Frontend.ToolBarButtons.NewSlogoButton;
import slogo.Frontend.ToolBarButtons.PenColorPicker;
import slogo.Frontend.ToolBarButtons.SelectBackgroundColorButton;
import slogo.Frontend.ToolBarButtons.ToolBarButtonAbstract;
import slogo.Frontend.ToolBarButtons.TurtleImageChooserButton;

public class ToolBarUI {

  private ToolBar mytoolBar;
  private ToolBarButtonAbstract commandHistoryButton;
  private LanguageSelect languageSelect;
  private ToolBarButtonAbstract colorButton;
  private Pane buttonBarContainer;
  private ToolBarButtonAbstract turtleImageButton;
  private ToolBarButtonAbstract newSlogoButton;
  private PenColorPicker penColorPicker;
  private TurtleView myTurtleView;
  private BackgroundColorPicker backgroundColorPicker;
  private TurtleBackground myTurtleBackground;


  public ToolBarUI(TurtleBackground turtleBackground){
    myTurtleBackground = turtleBackground;
    buttonBarContainer = new HBox(5);
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

  public void setTurtleView(TurtleView curTurtleView){
    myTurtleView = curTurtleView;
    penColorPicker = new PenColorPicker(myTurtleView.getTurtlePen());
    turtleImageButton =  new TurtleImageChooserButton("Choose Turtle Image", myTurtleView);
    buttonBarContainer.getChildren().addAll(penColorPicker.getColorPickerContainer(), turtleImageButton.getButton());
  }

  private void createToolBar(){
    commandHistoryButton = new CommandHistoryToolbarButton("Command History");
    commandHistoryButton.getButton().setId("CommandHistoryButton");
    languageSelect = new LanguageSelect("English");
    languageSelect.getChoiceBox().setId("SelectDisplayLanguage");
    backgroundColorPicker = new BackgroundColorPicker(myTurtleBackground);


    buttonBarContainer.getChildren().addAll(commandHistoryButton.getButton(), languageSelect.getChoiceBox(),
        backgroundColorPicker.getColorPickerContainer()); mytoolBar.getItems().addAll(buttonBarContainer);
  }

}
