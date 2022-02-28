package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Forward implements TurtleTransformer {

  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Forward(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, Double> transform() {
    double turtleAngle = myOldTurtle.getDirection().getDirectionInRadians();
    double oldX = myOldTurtle.getLocation().getX();
    double oldY = myOldTurtle.getLocation().getY();
    double newX = oldX + myParams.get(0) * Math.cos(turtleAngle);
    double newY = oldY + myParams.get(0) * Math.sin(turtleAngle);
    return Map.of(Turtle.X, newX, Turtle.Y, newY);
  }

}
