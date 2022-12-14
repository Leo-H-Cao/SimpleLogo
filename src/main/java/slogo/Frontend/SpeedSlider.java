package slogo.Frontend;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Slider to adjust speed of animation
 * @author: Leo Cao
 */
public class SpeedSlider extends Sslider {
  public static final double MIN_VALUE = .25;
  public static final double MAX_VALUE = 4;
  public static final double STARTING_VALUE = 1;
  public static final String SPEED_LABEL = "Animation Speed";

  // To refactor should probably make it to where you can not access the slider data structure
  public SpeedSlider() {
    super(MIN_VALUE, MAX_VALUE, STARTING_VALUE);
    this.getSlider().getStyleClass().add("speed-slider");
    this.getSlider().setId("speedSlider");
  }

  public double getValue() {
    return getSlider().getValue();
  }
}
