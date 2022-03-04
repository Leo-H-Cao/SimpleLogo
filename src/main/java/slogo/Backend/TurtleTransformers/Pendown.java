package slogo.Backend.TurtleTransformers;

import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;
import slogo.Backend.TurtleState.Turtle;

public class Pendown implements TurtleTransformer {
  private Turtle myOldTurtle;
  private List<Double> myParams;

  public Pendown(Turtle oldTurtle, List<Double> params){
    myOldTurtle = oldTurtle;
    myParams = params;
  }

  @Override
  public Map<String, FieldValue> transform() {
    return Map.of(Turtle.PENDOWN, new FieldValue<Boolean>(true));
  }

}