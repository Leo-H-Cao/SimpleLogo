package slogo.Backend;

import java.util.ArrayDeque;
import java.util.Deque;
import slogo.Backend.TurtleState.Turtle;

/** The type Result. */
public class Result {
  private final double doubleReturned;
  private final ArrayDeque<Turtle> turtleSteps;

  public Result(double doubleReturned, ArrayDeque<Turtle> turtleSteps)
  {
    this.doubleReturned = doubleReturned;
    this.turtleSteps = turtleSteps;
  }

  /**
   * @return numeric return value of the entire set of commands submitted
   */
  public double getIntReturned() {
    return doubleReturned;
  }

  /**
   * @return ArrayDeque of new turtles resulting from executing this set of commands, with the first
   * turtle in the deque being the original turtle before execution
   */
  public ArrayDeque<Turtle> getTurtleSteps(){
    return turtleSteps;
  }
}
