package slogo.Frontend;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ControlPanel {

  private Pane controlPanelContainer;
  private SpeedSlider mySpeedSlider;

  public ControlPanel(){
    controlPanelContainer = new VBox();
    controlPanelContainer.getStyleClass().add("control-panel-container");
    mySpeedSlider = new SpeedSlider();
    addControlNodes();
  }

  public Pane getControlPanelContainer() {
    return controlPanelContainer;
  }

  private void addControlNodes(){
    controlPanelContainer.getChildren().add(mySpeedSlider.getSliderBox());
  }

  public SpeedSlider getSpeedSlider() {
    return mySpeedSlider;
  }
}
