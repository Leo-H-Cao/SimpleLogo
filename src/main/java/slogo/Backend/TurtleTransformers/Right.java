package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Right implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Right(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, Double> transform() {
    double turtleAngle = myOldTurtle.getDirection().getDirectionInRadians();
    double newTurtleAngle = turtleAngle - Math.toRadians(myParams.get(0));
    return Map.of(Turtle.DIRECTION, newTurtleAngle);
  }

}