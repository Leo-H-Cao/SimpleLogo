package slogo.Frontend;

import javafx.scene.control.Slider;

public abstract class Sslider {


  private Slider mySlider;
  public Sslider(double min, double max, double startingValue){
    mySlider = new Slider(min, max, startingValue);
  }


  public Slider getSlider(){
    return mySlider;
  }
}
