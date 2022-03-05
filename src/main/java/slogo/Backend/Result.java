package slogo.Backend;

import java.util.ArrayDeque;
import java.util.Deque;
import slogo.Backend.TurtleState.Turtle;

/**
 * This class tests the Lexical Analyzer
 * @author Alex
 * */
public class Result {
  private final double doubleReturned;
  private final ArrayDeque<Turtle> turtleSteps;

  public Result(double doubleReturned, ArrayDeque<Turtle> turtleSteps)
  {
    this.doubleReturned = doubleReturned;
    this.turtleSteps = turtleSteps;
  }

  public double getIntReturned() {
    return doubleReturned;
  }

  public ArrayDeque<Turtle> getTurtleSteps(){
    return turtleSteps;
  }
}
