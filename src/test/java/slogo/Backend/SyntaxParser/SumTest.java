package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumTest {

  Sum mySum;

  @BeforeEach
  void setup() {
    mySum = new Sum(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal() {
    assertEquals(12.0, mySum.getRetVal());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, mySum.getMyNumArgs());
  }
}
