package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.Math.Difference;
import slogo.Backend.TurtleState.Turtle;

public class DifferenceTest {
  Difference myDifference;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myDifference = new Difference(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(8.0, myDifference.getRetVal());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myDifference.getMyNumArgs());
  }
}
