package slogo.Backend.SyntaxParser.ControlFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.FileReadingException;
import slogo.Backend.SyntaxParser.Data.Constant;
import slogo.Backend.SyntaxParser.Data.Variable;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.TurtleCommand.Forward;
import slogo.Backend.TurtleState.Turtle;

public class ForTest {
  For myFor;
  private LogoRuntimeState myRuntimeState;

  @BeforeEach
  void setup() {
    myFor = new For(0);

    myRuntimeState = new LogoRuntimeState();
    ArrayDeque<Turtle> currentHistory = new ArrayDeque<>();
    currentHistory.addLast(new Turtle(new int[]{0, 0}, 0, true));
    myRuntimeState.getHistory().getTurtleHistory().addLast(currentHistory);
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


    LogoList l1 = new LogoList(0);
    LogoList l2 = new LogoList(0);
    Constant start = new Constant(0,5);
    Constant end = new Constant(0,7);
    Constant increment = new Constant(0,1);
    Variable v = new Variable(0);
    v.setName(":var");
    l1.addArgument(increment);
    l1.addArgument(end);
    l1.addArgument(start);
    l1.addArgument(v);
    Forward forward = new Forward(0);

    forward.addArgument(new Constant(0,10));
    l2.addArgument(forward);
    myFor.addArgument(l2);
    myFor.addArgument(l1);
    myFor.getRetVal(myRuntimeState);
    assertEquals(20, myRuntimeState.getHistory().getTurtleHistory().getLast().getLast().getLocation().getX());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myFor.getMyNumArgs());
  }

}