package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Left implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Left(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, Double> transform() {
    double turtleAngle = myOldTurtle.getHeadingDirection();
    double newTurtleAngle = turtleAngle + myParams.get(0);
    return Map.of(Turtle.DIRECTION, newTurtleAngle);
  }

}