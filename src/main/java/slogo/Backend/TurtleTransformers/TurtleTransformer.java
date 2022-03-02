package slogo.Backend.TurtleTransformers;

import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;

public interface TurtleTransformer {
  Map<String, FieldValue> transform();

}
