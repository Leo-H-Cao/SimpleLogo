package slogo.Backend.TurtleState;

public class Direction {
  private final double directionInRadians;

  public Direction(Double directionInRadians){
    this.directionInRadians = directionInRadians;
  }

  public double getDirectionInDegrees() {
    return (directionInRadians * 180)/Math.PI;
  }
}
