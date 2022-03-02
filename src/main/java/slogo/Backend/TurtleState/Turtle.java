package slogo.Backend.TurtleState;

import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Turtle {
  public static final String X = "x";
  public static final String Y = "y";
  public static final String DIRECTION = "direction";
  public static final String PENDOWN = "pen_down";

  private Coordinate coordinate;
  private Direction direction;
  //private double headingDirection; //angle in radians
  private boolean penDown;

  public Turtle(int[] location, double headingDirection, boolean penDown){
    this.coordinate = new Coordinate(location[0], location[1]);
    this.direction = new Direction(headingDirection);
    this.penDown = penDown;
  }

  /*
  private Turtle(int[] location, double headingDirection, boolean penDown) {
    this.coordinate = new Coordinate(location[0], location[1]);
    this.headingDirection = headingDirection;
    this.penDown = penDown;
  }
*/
  // TODO: make this not a constructor so that it can be part of a Turtle abstract class. Either make a Turtle Factory of a method of Turtle that can create new Turtles
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

  /*
  public double getHeadingDirection(){
    return headingDirection;
  }
*/
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

  public Turtle getInitialTurtle() {
    // TODO: implement Turtle initialization
    return null;
  }

  public Coordinate getLocation() {
    return coordinate;
  }

  public Direction getDirection() {
    return direction;
  }



//  protected Turtle forward(double distance) {
//    return null;
//  }
//
//  protected Turtle backward(double distance) {
//    return null;
//  }
//
//  protected Turtle left(double distance) {
//    return null;
//  }
//
//  protected Turtle right(double distance) {
//    return null;
//  }
//
//  protected Turtle setHeading() {
//    return null;
//  }
//
//  protected Turtle setTowards() {
//    return null;
//  }
//
//  protected Turtle setPosition(Coordinate coordinate) {
//    return null;
//  }
//
//  protected Turtle penDown() {
//    return null;
//  }
//
//  protected Turtle penUp() {
//    return null;
//  }
//
//  protected Turtle showTurtle() {
//    return null;
//  }
//
//  protected Turtle hideTurtle() {
//    return null;
//  }
//
//  protected Turtle home() {
//    return null;
//  }
//
//  protected Turtle clearScreen() {
//    return null;
//  }
//
//  protected Turtle xCoordinate() {
//    return null;
//  }
//
//  protected Turtle yCoordinate() {
//    return null;
//  }
//
//  protected Turtle heading() {
//    return null;
//  }
//
//  protected Boolean isPenDown() {
//    return null;
//  }
//
//  protected Boolean isShowing() {
//    return null;
//  }
//
//  protected Double sum() {
//    return null;
//  }
//
//  protected Double difference() {
//    return null;
//  }
//
//  protected Turtle product() {
//    return null;
//  }
//
//  protected Turtle quotient() {
//    return null;
//  }
//
//  protected Turtle remainder() {
//    return null;
//  }
//
//  protected Turtle minus() {
//    return null;
//  }
//
//  protected Turtle random() {
//    return null;
//  }
//
//  protected Turtle randomRange() {
//    return null;
//  }
//
//  protected Turtle sine() {
//    return null;
//  }
//
//  protected Turtle cosine() {
//    return null;
//  }
//
//  protected Turtle tangent() {
//    return null;
//  }
//
//  protected Turtle arcTangent() {
//    return null;
//  }
//
//  protected Turtle squareRoot() {
//    return null;
//  }
//
//  protected Turtle naturalLog() {
//    return null;
//  }
//
//  protected Turtle power() {
//    return null;
//  }
//
//  protected Turtle pi() {
//    return null;
//  }
//
//  protected Turtle lessThan() {
//    return null;
//  }
//
//  protected Turtle lessEqual() {
//    return null;
//  }
//
//  protected Turtle greaterThan() {
//    return null;
//  }
//
//  protected Turtle greaterEgual() {
//    return null;
//  }
//
//  protected Turtle equal() {
//    return null;
//  }
//
//  protected Turtle notEqual() {
//    return null;
//  }
//
//  protected Turtle and() {
//    return null;
//  }
//
//  protected Turtle or() {
//    return null;
//  }
//
//  protected Turtle not() {
//    return null;
//  }
//
//  protected Turtle makeVariable() {
//    return null;
//  }
//
//  protected Turtle repeat() {
//    return null;
//  }
//
//  protected Turtle doTimes() {
//    return null;
//  }
//
//  protected Turtle For() {
//    return null;
//  }
//
//  protected Turtle If() {
//    return null;
//  }
//
//  protected Turtle ifElse() {
//    return null;
//  }
//
//  protected Turtle makeUserInstruction() {
//    return null;
//  }
}
