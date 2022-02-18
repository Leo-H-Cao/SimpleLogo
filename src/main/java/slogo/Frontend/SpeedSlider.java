package slogo.Frontend;

public class SpeedSlider extends Sslider {
  public static final int SIZE = 50;
  public static final double MIN_VALUE = .25;
  public static final double MAX_VALUE = 1.75;
  public static final double STARTING_VALUE = 1;

  public SpeedSlider(){
    super(MIN_VALUE, MAX_VALUE, STARTING_VALUE);

  }

}
