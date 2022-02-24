package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuotientTest {

  Quotient myQuotient;

  @BeforeEach
  void setup() {
    myQuotient = new Quotient(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal() {
    assertEquals(5.0, myQuotient.getRetVal());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myQuotient.getMyNumArgs());
  }
}
