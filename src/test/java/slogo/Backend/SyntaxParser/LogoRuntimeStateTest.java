package slogo.Backend.SyntaxParser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.TurtleState.Turtle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoRuntimeStateTest {

  LogoRuntimeState myRuntimeState;

  @BeforeEach
  void setup() {
    myRuntimeState = new LogoRuntimeState();
    ArrayDeque<Turtle> currentHistory = new ArrayDeque<>();
    currentHistory.addLast(new Turtle(new int[]{0, 0}, 0, true));
    myRuntimeState.getHistory().getTurtleHistory().addLast(currentHistory);
  }

  @Test
  void testAddAndGetVariable(){
    myRuntimeState.setVariableValue(":var1", 2.0);
    assertEquals(2.0,myRuntimeState.evaluateVariable(":var1"));
  }

  @Test
  void testGetFunction()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Operator c = new Constant(0,10);
    myRuntimeState.addFunction("evaluateConstant", c);
    assertEquals(myRuntimeState.getFunction("evaluateConstant").getRetVal(myRuntimeState),10.0);

  }


}
