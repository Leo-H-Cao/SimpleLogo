package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.TurtleState.Turtle;

public class SumTest {

  Sum mySum;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    mySum = new Sum(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal() {
    assertEquals(12.0, mySum.getRetVal(myTurtleStack));
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, mySum.getMyNumArgs());
  }
}
