package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class PiTest {
  Pi myPi;

  @BeforeEach
  void setup() {
    myPi = new Pi(0);
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(
        TestUtils.testEqualsWithTolerance(myPi.getRetVal(new TurtleHistory()), Math.PI, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(0, myPi.getMyNumArgs());
  }
}