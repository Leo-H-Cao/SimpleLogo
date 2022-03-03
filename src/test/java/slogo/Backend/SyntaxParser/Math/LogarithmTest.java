package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
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
        TestUtils.testEqualsWithTolerance(myLogarithm.getRetVal(null), 1, 0.0001));
  }

  @Test
  void testIllegalInput()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    myLogarithm = new Logarithm(new Constant(0, -1));
    assertThrows(IllegalArgumentException.class, () -> myLogarithm.getRetVal(new LogoRuntimeState()));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myLogarithm.getMyNumArgs());
  }
}