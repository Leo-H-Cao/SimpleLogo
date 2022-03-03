package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;

class ArcTangentTest {
  ArcTangent myArcTangent;

  @BeforeEach
  void setup() {
    myArcTangent = new ArcTangent(new Constant(0, 1));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(45.0, myArcTangent.getRetVal(null));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(1, myArcTangent.getMyNumArgs());
  }
}