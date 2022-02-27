package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.Math.Sum;
import slogo.Backend.TurtleState.Turtle;

public class SumTest {

  Sum mySum;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    mySum = new Sum(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(12.0, mySum.getRetVal());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, mySum.getMyNumArgs());
  }
}
