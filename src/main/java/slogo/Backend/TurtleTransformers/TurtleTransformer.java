package slogo.Backend.TurtleTransformers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import slogo.Backend.TurtleState.Turtle;

public interface TurtleTransformer {
  Map<String, Double> transform(Turtle oldTurtle, List<Double> params);

}
