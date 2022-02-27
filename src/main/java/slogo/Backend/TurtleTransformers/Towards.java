package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Towards implements TurtleTransformer {

  @Override
  public Map<String, Double> transform(Turtle oldTurtle, List<Double> params) {
    //implemented to assume forward is to move positive x for sake of example, use trig to fix later
    double newX = params.get(0);
    double newY = params.get(1);

    double dx = newX - oldTurtle.getLocation().getX();
    double dy = newY - oldTurtle.getLocation().getY();
    double newAngle;

    if(dy==0 && dx==0){
      newAngle = oldTurtle.getHeadingDirection();
    }
    else if(dx==0 && dy>0){
      newAngle = Math.PI / 2;
    }
    else if (dx==0 && dy< 0){
      newAngle = (Math.PI * 3) / 2;
    }
    else {
      newAngle = Math.atan2(dy, dx);
    }

    return Map.of(Turtle.DIRECTION, newAngle);
  }

}