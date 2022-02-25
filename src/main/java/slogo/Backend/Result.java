package slogo.Backend;

import java.util.Deque;
import slogo.Backend.TurtleState.Turtle;

/** The type Result. */
public class Result {
  private final double doubleReturned;
  private final Deque<Turtle> turtleSteps;

  public Result(double doubleReturned, Deque<Turtle> turtleSteps)
  {
    this.doubleReturned = doubleReturned;
    this.turtleSteps = turtleSteps;
  }

  public double getIntReturned() {
    return doubleReturned;
  }

  public Deque<Turtle> getTurtleSteps(){
    return turtleSteps;
  }
}
