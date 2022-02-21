package slogo.Frontend;

import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class Sslider {

  private final Slider mySlider;
  private final Pane sliderBox;

  /** Should use reflection instead of all these getters and setters for label */
  public Sslider(double min, double max, double startingValue) {
    mySlider = new Slider(min, max, startingValue);
    sliderBox = new VBox();
    sliderBox.getChildren().add(mySlider);
    setLabel(sliderBox);
  }

  public Slider getSlider() {
    return mySlider;
  }

  public Pane getSliderBox() {
    return sliderBox;
  }

  public abstract void setLabel(Pane box);
}
