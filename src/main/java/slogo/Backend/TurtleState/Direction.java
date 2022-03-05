package slogo.Backend.TurtleState;

/**
 * This class has the Direction where the Turtle is facing - it is
 * able to return a direction in radians or degrees as needed
 * @author Jed & Alex
 * */
public class Direction {
  private final double directionInRadians;

  public Direction(Double directionInRadians){
    this.directionInRadians = directionInRadians;
  }

  public double getDirectionInDegrees() {
    return (directionInRadians * 180)/Math.PI;
  }

  public double getDirectionInRadians(){
    return directionInRadians;
  }
}
