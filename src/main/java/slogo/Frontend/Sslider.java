package slogo.Frontend;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public abstract class Sslider {
  public static final boolean TICK_MARKS = true;

  private HBox myHbox;
  private Slider mySlider;
  public Sslider(double min, double max, double startingValue){
    mySlider = new Slider(min, max, startingValue);
    mySlider.setShowTickMarks(TICK_MARKS);
    //myHbox = FXUtils.createHBox(mySlider);
  }

  private HBox getHBox(){
    return myHbox;
  }
  private Slider getSlider(){
    return mySlider;
  }
}
