package slogo.Backend.TurtleState;

import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

/**
 * This class holds the data and behavior for Turtles
 * @author Alex
 * */
public class Turtle {
  public static final String X = "x";
  public static final String Y = "y";
  public static final String DIRECTION = "direction";
  public static final String PENDOWN = "pen_down";

  private Coordinate coordinate;
  private Direction direction;
  private boolean penDown;

  public Turtle(int[] location, double headingDirection, boolean penDown){
    this.coordinate = new Coordinate(location[0], location[1]);
    this.direction = new Direction(headingDirection);
    this.penDown = penDown;
  }

  // TODO: make this not a constructor so that it can be part of a Turtle abstract class. Either make a Turtle Factory of a method of Turtle that can create new Turtles

  /**
   * This constructor allows the caller to create a new Turtle through a well-defined "transformation" of
   * the turtle. This constructor allows its caller to safely create a new Turtle through a transformation
   * without having to know which exact transformation it is using or the details of the transformation,
   * providing a unified API
   * @param oldTurtle the old Turtle who is "transformed" into the Turtle returned
   * @param turtleTransformer an arbitrary Turtle Transformation class which has a unified api
   *                          for getting the arguments needed to construct the next Turtle
   * @param arguments the arguments of the Turtle transformation
   */
  public Turtle(Turtle oldTurtle, TurtleTransformer turtleTransformer, List<?> arguments) {
    Map<String,FieldValue> oldFields = oldTurtle.getMapOfState();
    Map<String, FieldValue> overridingFields = turtleTransformer.transform();

    //creates new turtle with same fields as old turtle, except updates them where applicable due to having different values for certain fields
    FieldValue<Double> xValue = overridingFields.getOrDefault(Turtle.X, oldFields.get(Turtle.X));
    Double x = xValue.getValue();
    FieldValue<Double> yValue = overridingFields.getOrDefault(Turtle.Y, oldFields.get(Turtle.Y));
    Double y = yValue.getValue();
    FieldValue<Double> angleValue = overridingFields.getOrDefault(Turtle.DIRECTION, oldFields.get(Turtle.DIRECTION));
    Double angle = angleValue.getValue();
    FieldValue<Boolean> penDownValue = overridingFields.getOrDefault(Turtle.PENDOWN, oldFields.get(Turtle.PENDOWN));
    Boolean pendown = penDownValue.getValue();

    this.coordinate = new Coordinate(x,y);
    this.direction = new Direction(angle);
    this.penDown = pendown;

  }

  private Map<String, FieldValue> getMapOfState() {
    return Map.ofEntries(
        Map.entry(Turtle.X, new FieldValue<Double>(coordinate.getX())),
        Map.entry(Turtle.Y, new FieldValue<Double>(coordinate.getY())),
        Map.entry(Turtle.DIRECTION, new FieldValue<Double>(direction.getDirectionInRadians())),
        Map.entry(Turtle.PENDOWN, new FieldValue<Boolean>(penDown))
        );
  }

  private Turtle(double x, double y, double direction){
    this.coordinate = new Coordinate(x, y);
    this.direction = new Direction(direction);
  }

  /**
   * Returns the location of the Turtle
   * @return location in a Coordinate object
   */
  public Coordinate getLocation() {
    return coordinate;
  }

  /**
   * Returns the direction in a Direction object
   * @return Direction object with the direction of the Turtle
   */
  public Direction getDirection() {
    return direction;
  }

}
