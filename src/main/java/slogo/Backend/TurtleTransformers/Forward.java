package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Forward implements TurtleTransformer {

  @Override
  public Map<String, Double> transform(Turtle oldTurtle, List<Double> params) {
    double turtleAngle = oldTurtle.getHeadingDirection();
    double oldX = oldTurtle.getLocation().getX();
    double oldY = oldTurtle.getLocation().getY();
    double newX = oldX + params.get(0) * Math.cos(turtleAngle);
    double newY = oldY + params.get(0) * Math.sin(turtleAngle);
    return Map.of(Turtle.X, newX, Turtle.Y, newY);
  }

}
