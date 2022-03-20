package slogo.Backend.TurtleState;

/**
 * This class holds the "Coordinate" where the Turtle is at. It holds
 * an x and y value because our Turtles exist on a 2d cartesian plane, but subclasses
 * could extend this (say to a 3d world by adding z)
 * @author Alex
 * */
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
