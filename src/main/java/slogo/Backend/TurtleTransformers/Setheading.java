package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;
import slogo.Backend.TurtleState.Turtle;

public class Setheading implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Setheading(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, FieldValue> transform() {
    return Map.of(Turtle.DIRECTION, new FieldValue<Double>(myParams.get(0)));
  }

}