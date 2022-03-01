package slogo.Frontend;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import slogo.Frontend.ControlPanelButtons.ControlPanelButtonAbstract;
import slogo.Frontend.ControlPanelButtons.ResetAnimationButton;

public class ControlPanel {

  private final Pane controlPanelContainer;
  private final SpeedSlider mySpeedSlider;
  private ControlPanelButtonAbstract resetAnimationButton;

  public ControlPanel() {
    controlPanelContainer = new VBox();
    controlPanelContainer.getStyleClass().add("control-panel-container");
    mySpeedSlider = new SpeedSlider();
    resetAnimationButton = new ResetAnimationButton("Reset");
    addControlNodes();
  }

  public Pane getControlPanelContainer() {
    return controlPanelContainer;
  }

  private void addControlNodes() {
    controlPanelContainer.getChildren().addAll(mySpeedSlider.getSliderBox(), resetAnimationButton.getButton());
  }

  public SpeedSlider getSpeedSlider() {
    return mySpeedSlider;
  }
}
