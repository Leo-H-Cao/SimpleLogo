package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class SquareRootTest {
  SquareRoot mySquareRoot;

  @BeforeEach
  void setup() {
    mySquareRoot = new SquareRoot(new Constant(0, 64));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(
        TestUtils.testEqualsWithTolerance(mySquareRoot.getRetVal(null), 8.0, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, mySquareRoot.getMyNumArgs());
  }
}