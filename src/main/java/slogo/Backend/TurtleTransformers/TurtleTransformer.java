package slogo.Backend.TurtleTransformers;

import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;

/**
 * This interface represents classes that represent SLogo commands which cause a turtle to move.
 */
public interface TurtleTransformer {
  Map<String, FieldValue> transform();

}
