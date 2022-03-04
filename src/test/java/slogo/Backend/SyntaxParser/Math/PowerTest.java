package slogo.Backend.SyntaxParser.Math;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Data.Constant;

class PowerTest {
  Power myPower;

  @BeforeEach
  void setup() {
    this.myPower = new Power(new Constant(0, 2.0), new Constant(0, 6.0));
  }

  @Test
  void testGetRetVal() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Assertions.assertEquals(64.0, this.myPower.getRetVal(null));
  }

  @Test
  void testNegativeExponent() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    myPower = new Power(new Constant(0, 2.0), new Constant(0, -1.0));
    Assertions.assertEquals(0.5, this.myPower.getRetVal(null));
  }

  @Test
  void testGetMyNumArgs() {
    Assertions.assertEquals(2, this.myPower.getMyNumArgs());
  }
}