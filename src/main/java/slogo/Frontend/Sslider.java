package slogo.Frontend;

import javafx.scene.control.Slider;

public abstract class Sslider {
  public static final boolean SHOW_TICK_MARKS = true;
  public static final boolean SHOW_TICK_LABELS = true;
  public static final boolean SNAPPING = true;


  private Slider mySlider;
  public Sslider(double min, double max, double startingValue){
    mySlider = new Slider(min, max, startingValue);
    mySlider.setShowTickMarks(SHOW_TICK_MARKS);
    mySlider.setShowTickLabels(SHOW_TICK_LABELS);
    mySlider.setSnapToTicks(SNAPPING);
  }


  public Slider getSlider(){
    return mySlider;
  }
}
