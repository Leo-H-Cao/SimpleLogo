package slogo.Backend.SyntaxParser.ControlFlow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.Constant;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;
import slogo.Backend.SyntaxParser.Math.Product;
import slogo.Backend.SyntaxParser.TurtleCommand.Forward;
import slogo.Backend.TurtleState.Turtle;

public class RepeatTest {
  Repeat myRepeat;
  private TurtleHistory myTurtleHistory;

  @BeforeEach
  void setup() {
    myRepeat = new Repeat(0);

    myTurtleHistory = new TurtleHistory();
    ArrayDeque<Turtle> currentHistory = new ArrayDeque<>();
    currentHistory.addLast(new Turtle(new int[]{0, 0}, 0, true));
    myTurtleHistory.getTurtleHistory().addLast(currentHistory);
  }

  @Test
  void testGetRetVal()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    Constant iterations = new Constant(0,4);
    LogoList l = new LogoList(0);
    Forward forward = new Forward(0);
    Constant forwardAmount = new Constant(0,50);

    forward.addArgument(forwardAmount);
    l.addArgument(forward);
    myRepeat.addArgument(l);
    myRepeat.addArgument(iterations);
    myRepeat.getRetVal(myTurtleHistory);
    assertEquals(200,myTurtleHistory.getTurtleHistory().getLast().getLast().getLocation().getX());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myRepeat.getMyNumArgs());
  }

}
