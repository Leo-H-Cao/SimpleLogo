package slogo.Backend.SyntaxParser.ControlFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.LogoRuntimeState;

public class DoTimesTest {
  DoTimes myDoTimes;
  private LogoRuntimeState myRuntimeState;

  @BeforeEach
  void setup() {
    myDoTimes = new DoTimes(0);


  }


  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myDoTimes.getMyNumArgs());
  }

}