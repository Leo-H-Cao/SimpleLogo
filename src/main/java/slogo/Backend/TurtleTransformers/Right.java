package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;
import slogo.Backend.TurtleState.Turtle;

public class Right implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Right(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, FieldValue> transform() {
    double turtleAngle = myOldTurtle.getDirection().getDirectionInRadians();
    double newTurtleAngle = turtleAngle - Math.toRadians(myParams.get(0));
    return Map.of(Turtle.DIRECTION, new FieldValue<Double>(newTurtleAngle));
  }

}