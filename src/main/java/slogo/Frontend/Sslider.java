package slogo.Frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class Sslider {
  public static final String SPEED_LABEL = "Animation Speed";

  private final Slider mySlider;
  private final VBox sliderBox;

  /** Should use reflection instead of all these getters and setters for label */
  public Sslider(double min, double max, double startingValue) {
    mySlider = new Slider(min, max, startingValue);
    sliderBox = new VBox(3);
    sliderBox.setAlignment(Pos.TOP_CENTER);
    Label speedLabel = new Label(SPEED_LABEL);
    sliderBox.getChildren().add(speedLabel);
    sliderBox.getChildren().add(mySlider);
  }

  public Slider getSlider() {
    return mySlider;
  }

  public Pane getSliderBox() {
    return sliderBox;
  }
}
