package slogo.Backend.TurtleState;

public class Coordinate {

  private final double x;
  private final double y;

  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public Coordinate(Double x, Double y) {
    this.x = (double) x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
