package slogo.Frontend.ControlPanelButtons;

public class ResetAnimationButton extends ControlPanelButtonAbstract{

  /**
   * Abstract class for control panel buttons such as pause, play, reset
   * @author Leo Cao
   */
  public ResetAnimationButton(String buttonName) {
    super(buttonName);
    myButton.setOnAction(actionEvent -> {
      //TODO: handle resetting animation
    });
  }
}
