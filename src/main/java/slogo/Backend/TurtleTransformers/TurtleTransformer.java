package slogo.Backend.TurtleTransformers;

import java.util.Map;
import slogo.Backend.TurtleState.FieldValue;

/**
 * This class tests the Lexical Analyzer
 * @author Alex
 * */
public interface TurtleTransformer {
  Map<String, FieldValue> transform();

}
