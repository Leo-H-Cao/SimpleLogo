package slogo.Backend;

import javafx.scene.control.skin.TextInputControlSkin.Direction;

public class Turtle {
  private Coordinate coordinate;
  private Direction direction;


  public Coordinate getLocation()  {
    return coordinate;
  }

  public Direction getDirection() {
    return direction;
  }

}
