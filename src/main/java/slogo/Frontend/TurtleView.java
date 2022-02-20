package slogo.Frontend;

import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.control.skin.TextInputControlSkin.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.shape.LineTo;
import javafx.util.Duration;
import slogo.Backend.Coordinate;
import slogo.Backend.Turtle;
import slogo.FrontendExternalAPIs.DisplayCanvas;
import slogo.FrontendExternalAPIs.DisplayTurtle;


public class TurtleView implements DisplayTurtle, DisplayCanvas {

  public static final String TURTLE_IMAGE_PATH = "test-turtle.png";
  public static final int TURTLE_SIZE = 40;

  private Node turtleNode;
  private ImageView turtleImage;
  private Turtle initialTurtle;
  private Turtle turtle;

  public TurtleView(){
    turtleNode = makeActor();
  }

  // create sequence of animations
  Animation makeAnimation (Turtle nextTurtle) {
    // create something to follow
    Path path = new Path();
    path.getElements().addAll(new MoveTo(turtle.getLocation().getX(), turtle.getLocation().getY()),
        new LineTo(nextTurtle.getLocation().getX(), nextTurtle.getLocation().getY()));
    // create an animation where the shape follows a path
    PathTransition pt = new PathTransition(Duration.seconds(4), path, turtleNode);
    // create an animation that rotates the shape
    RotateTransition rt = new RotateTransition(Duration.seconds(3));
    rt.setByAngle(90);
    // put them together in order
    return new SequentialTransition(turtleNode, pt, rt);
  }

  // create something to animate
  private Node makeActor () {
    Image turtleImage = new Image(TURTLE_IMAGE_PATH);
    ImageView myImageView = new ImageView(turtleImage);
    myImageView.setFitWidth(TURTLE_SIZE);
    myImageView.setFitHeight(TURTLE_SIZE);
    myImageView.setId("turtle_graphic");
    return myImageView;
  }

  public Node getTurtleNode(){
    return turtleNode;
  }

  /**
   * creates turtle at coordinates specified by turtle object
   * FIXME: Have not yet done the actual changing of coords in box
   * @param initialTurtle
   */
  @Override
  public void createTurtle(Turtle initialTurtle){
    double x = initialTurtle.getLocation().getX();
    double y = initialTurtle.getLocation().getY();
    Direction direction = initialTurtle.getDirection();
    turtleImage = (ImageView) makeActor();
    turtle = initialTurtle;
    this.initialTurtle = initialTurtle;
  }

  /**
   * move turtle to coordinates as specified by turtle object
   * @param nextTurtle
   */
  @Override
  public void moveTurtle(Turtle nextTurtle){
//    double x = nextTurtle.getLocation().getX();
//    double y = nextTurtle.getLocation().getY();
//    Direction direction = nextTurtle.getDirection();
    makeAnimation(nextTurtle).play();
  }

  /**
   * Change image for turtle (instead of CSS style's default)
   * @param turtleImage
   */
  @Override
  public void setTurtleImage(Image turtleImage){
    this.turtleImage.setImage(turtleImage);
  }

  @Override
  public void rotateTurtle(){
  }

  /**
   * returns current turtle graphic
   * @return
   */
  @Override
  public Image getCurrentTurtleImage(){
    return turtleImage.getImage();
  }

  /**
   * clears screen and resets turtle to original position
   */
  @Override
  public void resetDisplay(){
    createTurtle(initialTurtle);

  }

  /**
   * changes background color
   */
  @Override
  public void setBackGroundColor(){

  }


}
