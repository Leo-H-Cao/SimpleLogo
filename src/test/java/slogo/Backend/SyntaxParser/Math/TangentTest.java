package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class TangentTest {
  Tangent myTangent;

  @BeforeEach
  void setup() {
    myTangent = new Tangent(new Constant(0, 45));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(
        TestUtils.testEqualsWithTolerance(myTangent.getRetVal(new TurtleHistory()), 1.0, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myTangent.getMyNumArgs());
  }
}