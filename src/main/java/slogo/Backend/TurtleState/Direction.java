package slogo.Backend.TurtleState;

/**
 * This class tests the Lexical Analyzer
 * @author Alex
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
