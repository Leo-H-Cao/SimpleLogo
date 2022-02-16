package slogo.Backend;

import javafx.scene.control.skin.TextInputControlSkin.Direction;

public class Turtle {
  private Coordinates coordinates;
  private Direction direction;


  public Coordinates getLocation()  {
    return coordinates;
  }

  public Direction getDirection() {
    return direction;
  }

}
