package slogo.Frontend;

public class SpeedSlider extends Sslider {
  public static final int SIZE = 50;
  public static final double MIN_VALUE = .25;
  public static final double MAX_VALUE = 4;
  public static final double STARTING_VALUE = 1;
  public static final int MAJOR_TICKS = 10;
  public static final int MINOR_TICKS = 10;


  // To refactor should probably make it to where you can not access the slider data structure
  public SpeedSlider(){
    super(MIN_VALUE, MAX_VALUE, STARTING_VALUE);
    getSlider().setPrefWidth(SIZE);
    getSlider().setMajorTickUnit(MAJOR_TICKS);
    getSlider().setMinorTickCount(MINOR_TICKS);

  }

}
