package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.TurtleState.Turtle;

public class QuotientTest {

  Quotient myQuotient;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myQuotient = new Quotient(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal() {
    assertEquals(5.0, myQuotient.getRetVal(myTurtleStack));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myQuotient.getMyNumArgs());
  }
}
