package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;

class MinusTest {
  Minus myMinus;

  @BeforeEach
  void setup() {
    myMinus = new Minus(new Constant(0, 100));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(-100.0, myMinus.getRetVal(new TurtleHistory()));
  }

  @Test
  void testNegativeInput()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    myMinus = new Minus(new Constant(0, -100));
    assertEquals(100.0, myMinus.getRetVal(new TurtleHistory()));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myMinus.getMyNumArgs());
  }
}