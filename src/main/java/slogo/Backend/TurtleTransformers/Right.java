package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Right implements TurtleTransformer {

  @Override
  public Map<String, Double> transform(Turtle oldTurtle, List<Double> params) {
    double turtleAngle = oldTurtle.getHeadingDirection();
    double newTurtleAngle = turtleAngle - params.get(0);
    return Map.of(Turtle.DIRECTION, newTurtleAngle);
  }

}