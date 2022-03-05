package slogo.Backend.SyntaxParser.ControlFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.TurtleCommand.Forward;
import slogo.Backend.TurtleState.Turtle;

public class IfTest {
  If myIf;
  private LogoRuntimeState myRuntimeState;

  @BeforeEach
  void setup() {
    myIf = new If(0);


  }


  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myIf.getMyNumArgs());
  }

}
