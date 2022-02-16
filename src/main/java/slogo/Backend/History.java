package slogo.Backend;

import java.util.Deque;

public class History {
  private Deque<Deque<Turtle>> turtleHistory;

  public Deque<Deque<Turtle>> getTurtleHistory() {
    return turtleHistory;
  }
}
