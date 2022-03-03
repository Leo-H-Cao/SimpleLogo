package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import util.TestUtils;

class RandomTest {
  Random myRandom;

  @BeforeEach
  void setup() {
    myRandom = new Random(new Constant(0, -90));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = myRandom.getRetVal(new TurtleHistory());
    assertTrue(retVal <= 0 && retVal >= -90);
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myRandom.getMyNumArgs());
  }
}