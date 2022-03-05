package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import slogo.Frontend.ToolbarPopups.CommandHistoryPopup;

public class CommandHistoryToolbarButton extends ToolBarButtonAbstract{

  private CommandHistoryPopup commandHistoryPopup;

  /**
   * Button to open command history
   * @param buttonName
   */
  public CommandHistoryToolbarButton(String buttonName){
    super(buttonName);
    myButton.getStyleClass().add("command-history-button");
    setupPopup();
  }

  private void setupPopup(){
    commandHistoryPopup = new CommandHistoryPopup(null);
    myButton.setOnAction(actionEvent -> {
      if (!commandHistoryPopup.getPopup().isShowing())
        commandHistoryPopup.getPopup().show(stage);
      else
        commandHistoryPopup.getPopup().hide();
    });
  }

}
