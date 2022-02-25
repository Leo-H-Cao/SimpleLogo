package slogo.Backend.State;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Deque;
import java.util.List;
import slogo.Backend.TurtleState.Turtle;
import slogo.Backend.TurtleTransformers.TurtleTransformer;

public class TurtleHistory {
  private Deque<Deque<Turtle>> turtleHistory;

  public Deque<Deque<Turtle>> getTurtleHistory() {
    return turtleHistory;
  }

  public void addTurtleThroughTransformation(String turtleTransformation, List<Double> params)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Turtle oldTurtle = turtleHistory.getLast().getLast();
    String className = "slogo.Backend.TurtleTransformers." + turtleTransformation;
    Class turtleTransformerClass= Class.forName(className);
    Constructor<TurtleTransformer> turtleTransformerConstructor = turtleTransformerClass.getConstructor(Turtle.class, List.class);
    TurtleTransformer turtleTransformer = turtleTransformerConstructor.newInstance(oldTurtle, params);
    Turtle newTurtle = new Turtle(oldTurtle, turtleTransformer, params);
    turtleHistory.getLast().addLast(newTurtle);
  }
}
