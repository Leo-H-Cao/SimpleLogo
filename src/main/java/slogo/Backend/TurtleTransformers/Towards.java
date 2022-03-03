package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;
import slogo.Backend.TurtleState.Turtle;

public class Towards implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Towards(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, FieldValue> transform() {
    //implemented to assume forward is to move positive x for sake of example, use trig to fix later
    double newX = myParams.get(0);
    double newY = myParams.get(1);

    double dx = newX - myOldTurtle.getLocation().getX();
    double dy = newY - myOldTurtle.getLocation().getY();
    double newAngle;

    if(dy==0 && dx==0){
      newAngle = myOldTurtle.getDirection().getDirectionInRadians();
    }
    else if(dx==0 && dy>0){
      newAngle = Math.PI / 2;
    }
    else if (dx==0 && dy< 0){
      newAngle = (Math.PI * 3) / 2;
    }
    else {
      newAngle = Math.atan(dy/dx);
    }

    return Map.of(Turtle.DIRECTION, new FieldValue<Double>(newAngle));
  }

}