package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class LogarithmTest {
  Logarithm myLogarithm;

  @BeforeEach
  void setup() {
    myLogarithm = new Logarithm(new Constant(0, Math.E));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(
        TestUtils.testEqualsWithTolerance(myLogarithm.getRetVal(new TurtleHistory()), 1, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myLogarithm.getMyNumArgs());
  }
}