package slogo.FrontendExternalAPIs;

import javafx.scene.image.Image;
import slogo.Backend.TurtleState.Turtle;

public abstract interface DisplayTurtle {

  /**
   * creates turtle at coordinates specified by turtle object
   * @param initialTurtle
   */
  public void createTurtle(Turtle initialTurtle);

  /**
   * move turtle to coordinates as specified by turtle object
   * @param nextTurtle
   */
  public void moveTurtle(Turtle nextTurtle);

  /**
   * Change image for turtle (instead of CSS style's default)
   * @param turtleImage
   */
  public void setTurtleImage(Image turtleImage);


  public void rotateTurtle();

  public Image getCurrentTurtleImage();


}
