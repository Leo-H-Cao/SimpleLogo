package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;
import slogo.Backend.TurtleState.Turtle;

/**
 * This class contains the implementation of the Back command, which moves a turtle backwards.
 *
 * @author Jed Yang
 */
public class Back implements TurtleTransformer {

  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Back(Turtle t, List<Double> params){
    myOldTurtle = t;
    myParams = params;
  }

  @Override
  public Map<String, FieldValue> transform() {
    Double turtleAngle = myOldTurtle.getDirection().getDirectionInRadians();
    Double oldX = myOldTurtle.getLocation().getX();
    Double oldY = myOldTurtle.getLocation().getY();
    Double newX = oldX - myParams.get(0) * Math.cos(turtleAngle);
    Double newY = oldY - myParams.get(0) * Math.sin(turtleAngle);
    return Map.of(Turtle.X, new FieldValue<Double>(newX), Turtle.Y, new FieldValue<Double>(newY));
  }

}