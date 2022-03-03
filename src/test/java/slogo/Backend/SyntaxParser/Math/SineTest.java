package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class SineTest {
  Sine mySine;

  @BeforeEach
  void setup() {
    mySine = new Sine(new Constant(0, 90));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(
        TestUtils.testEqualsWithTolerance(mySine.getRetVal(null), 1.0, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, mySine.getMyNumArgs());
  }
}