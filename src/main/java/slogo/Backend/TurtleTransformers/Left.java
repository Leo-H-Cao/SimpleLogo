package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Left implements TurtleTransformer {

  @Override
  public Map<String, Double> transform(Turtle oldTurtle, List<Double> params) {
    //implemented to assume forward is to move positive x for sake of example, use trig to fix later
    double turtleAngle = oldTurtle.getHeadingDirection();
    double newTurtleAngle = turtleAngle + params.get(0);
    return Map.of(Turtle.DIRECTION, newTurtleAngle);
  }

}