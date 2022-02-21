package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstantTest {

  Constant myConstant;

  @BeforeEach
  void setUp() {
    myConstant = new Constant(3);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getRetVal() {
    assertEquals(3, myConstant.getRetVal());
  }
}