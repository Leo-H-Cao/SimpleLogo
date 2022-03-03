package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class CosineTest {
  Cosine myCosine;

  @BeforeEach
  void setup() {
    myCosine = new Cosine(new Constant(0, 90));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertTrue(TestUtils.testEqualsWithTolerance(myCosine.getRetVal(new TurtleHistory()), 0.0, 0.0001));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myCosine.getMyNumArgs());
  }
}