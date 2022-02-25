package slogo.Backend;

import java.util.Deque;
import slogo.Backend.TurtleState.Turtle;

/** The type Result. */
public class Result {
  private final int intReturned;
  private final Deque<Turtle> turtleSteps;

  public Result(int intReturned, Deque<Turtle> turtleSteps)
  {
    this.intReturned = intReturned;
    this.turtleSteps = turtleSteps;
  }

  public int getIntReturned() {
    return intReturned;
  }

  public Deque<Turtle> getTurtleSteps(){
    return turtleSteps;
  }
}
