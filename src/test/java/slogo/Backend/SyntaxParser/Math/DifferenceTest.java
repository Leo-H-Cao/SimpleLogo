package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.TurtleState.Turtle;

public class DifferenceTest {
  Difference myDifference;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myDifference = new Difference(new Constant(0,10), new Constant(0,2));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(8.0, myDifference.getRetVal(null));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myDifference.getMyNumArgs());
  }
}
