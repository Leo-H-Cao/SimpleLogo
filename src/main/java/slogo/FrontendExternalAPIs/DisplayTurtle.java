package slogo.FrontendExternalAPIs;

import java.util.Deque;
import javafx.scene.image.Image;
import slogo.Backend.TurtleState.Turtle;

public interface DisplayTurtle {

  /**
   * creates turtle at coordinates specified by turtle object
   *
   * @param initialTurtle
   */
  void createTurtle(Turtle initialTurtle);

  /**
   * move turtle to coordinates as specified by turtle object
   *
   * @param turtles
   */
  void moveTurtle(Deque<Turtle> turtles);

  /**
   * Change image for turtle (instead of CSS style's default)
   *
   * @param turtleImage
   */
  void setTurtleImage(Image turtleImage);
}
