package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.TurtleState.Turtle;

class ConstantTest {

  Constant myConstant;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setUp() {
    myConstant = new Constant(3);
  }

  @AfterEach
  void tearDown() {}

  @Test
  void getRetVal() {
    assertEquals(3, myConstant.getRetVal());
  }
}
