package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Turtle;

public class Forward implements TurtleTransformer {

  @Override
  public Map<String, Double> transform(Turtle oldTurtle, List<Double> params) {
    //implemented to assume forward is to move positive x for sake of example, use trig to fix later
    double oldX = oldTurtle.getLocation().getX();
    double newX = oldX + params.get(1);
    return Map.of(Turtle.X, newX);
  }

}
