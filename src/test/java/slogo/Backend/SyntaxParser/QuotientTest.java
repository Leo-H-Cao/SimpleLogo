package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Math.Quotient;
import slogo.Backend.TurtleState.Turtle;

public class QuotientTest {

  Quotient myQuotient;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myQuotient = new Quotient(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(5.0, myQuotient.getRetVal(new TurtleHistory()));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myQuotient.getMyNumArgs());
  }
}
