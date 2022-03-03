package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;

class RandomRangeTest {
  RandomRange myRandomRange;

  @BeforeEach
  void setup() {
    myRandomRange = new RandomRange(new Constant(0, -10), new Constant(0, 50));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    double retVal = myRandomRange.getRetVal(null);
    assertTrue(retVal <= 50 && retVal >= -10);
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myRandomRange.getMyNumArgs());
  }
}