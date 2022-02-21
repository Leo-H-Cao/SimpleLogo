package slogo.Backend.State;

import java.util.Deque;
import slogo.Backend.TurtleState.Turtle;

public class History {
  private Deque<Deque<Turtle>> turtleHistory;

  public Deque<Deque<Turtle>> getTurtleHistory() {
    return turtleHistory;
  }
}
