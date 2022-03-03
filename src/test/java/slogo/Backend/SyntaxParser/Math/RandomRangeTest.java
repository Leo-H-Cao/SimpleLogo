package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.SyntaxParser.LogoRuntimeState;

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
  void testIllegalInput()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    myRandomRange = new RandomRange(new Constant(0, -1), new Constant(0, -10));
    assertThrows(IllegalArgumentException.class, () -> myRandomRange.getRetVal(new LogoRuntimeState()));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myRandomRange.getMyNumArgs());
  }
}