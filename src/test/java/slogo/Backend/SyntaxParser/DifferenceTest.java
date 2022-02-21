package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DifferenceTest {
  Difference myDifference;

  @BeforeEach
  void setup(){
    myDifference = new Difference(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal(){
    assertEquals(8.0,myDifference.getRetVal());
  }

  @Test
  void testGetMyNumArgs(){
    assertEquals(2,myDifference.getMyNumArgs());
  }
}
