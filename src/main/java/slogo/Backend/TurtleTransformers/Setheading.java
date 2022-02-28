package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Direction;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class Setheading implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Setheading(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, Double> transform() {
    return Map.of(Turtle.DIRECTION, myParams.get(0));
  }

}