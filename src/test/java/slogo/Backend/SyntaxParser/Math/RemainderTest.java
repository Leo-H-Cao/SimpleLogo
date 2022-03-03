package slogo.Backend.SyntaxParser.Math;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;

class RemainderTest {
  Remainder myRemainder;

  @BeforeEach
  void setup() {
    myRemainder = new Remainder(new Constant(0, 51), new Constant(0, 2));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Assertions.assertEquals(1.0, this.myRemainder.getRetVal(new TurtleHistory()));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myRemainder.getMyNumArgs());
  }
}