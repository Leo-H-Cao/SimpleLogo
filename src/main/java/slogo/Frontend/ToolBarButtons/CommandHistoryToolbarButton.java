package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import slogo.Frontend.CommandHistoryPopup;

public class CommandHistoryToolbarButton extends ToolBarButtonAbstract{

  private CommandHistoryPopup commandHistoryPopup;

  public CommandHistoryToolbarButton(String buttonName){
    super(buttonName);
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
