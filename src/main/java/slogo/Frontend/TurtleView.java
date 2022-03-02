package slogo.Frontend;

import java.util.Deque;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import slogo.Backend.TurtleState.Turtle;
import slogo.FrontendExternalAPIs.DisplayTurtle;

public class TurtleView implements DisplayTurtle {

  public static final int TURTLE_SIZE = 40;
  public static final int DEFAULT_SPEED = 4;

  private ImageView turtleImage;
  private Turtle currentTurtle;
  private Turtle initialTurtle;
  private double myAnimationSpeed;

  public TurtleView(double animationSpeed, String turtleImagePath) {
    createTurtleImage(turtleImagePath);
    myAnimationSpeed = animationSpeed;

//    set current and initial turtle
//    currentTurtle = initTurtle;
//    initialTurtle = initTurtle;
  }

  /**
   * move turtle to coordinates as specified by turtle object
   *
   * @param turtles Deque of Turtles that the TurtleView must move to
   */
  @Override
  public void moveTurtle(Deque<Turtle> turtles) {
    // First turtle in the Deque is always equal to the current turtle, so we do not want to move
    // it to itself
    turtles.pollFirst();

    makeTransitions(turtles).play();
  }

  // Creates a singular SequentialTransition that one animation per turtle update in the instruction chain
  private SequentialTransition makeTransitions(Deque<Turtle> turtles) {
    System.out.println(myAnimationSpeed);
    SequentialTransition transition = new SequentialTransition();
    int size = turtles.size();
    for (int i = 0; i < size; i++) {
      Turtle nextTurtle = turtles.pollFirst();
      transition.getChildren().add(makeAnimation(nextTurtle));
      currentTurtle = nextTurtle;
    }
    return transition;
  }

  // Creates an animation from one turtle to the next
  private Animation makeAnimation(Turtle nextTurtle) {
    SequentialTransition transition = new SequentialTransition(turtleImage);

    // If location didn't change, make a rotate transition, else make a path transition
    if(nextTurtle.getLocation().getX() == currentTurtle.getLocation().getX()
        && nextTurtle.getLocation().getY() == currentTurtle.getLocation().getY()) {
      transition.getChildren().add(makeRotateTransition(currentTurtle, nextTurtle));
    } else {
      transition.getChildren().add(makePathTransition(currentTurtle, nextTurtle));
    }
    return transition;
  }

  // Make a path transition from one turtle's location to another
  private PathTransition makePathTransition(Turtle current, Turtle next) {
    Path path = new Path();
    //offsetPathForAbsoluteCoords(path, turtleImage);

    path.getElements()
        .addAll(
            new MoveTo(current.getLocation().getX(), -1 * current.getLocation().getY()),
            new LineTo(next.getLocation().getX(), -1 * next.getLocation().getY()));

    PathTransition pt =
        new PathTransition(Duration.seconds(DEFAULT_SPEED / myAnimationSpeed), path, turtleImage);

    return pt;
  }

  // Make a rotate transition from one turtle's direction to another
  private RotateTransition makeRotateTransition(Turtle current, Turtle next) {
    RotateTransition rt = new RotateTransition(Duration.seconds(DEFAULT_SPEED / myAnimationSpeed));
    double angleToRotate = -1 * (next.getDirection().getDirectionInDegrees() - current.getDirection().getDirectionInDegrees());
    rt.setByAngle(angleToRotate);
    return rt;
  }

  private void offsetPathForAbsoluteCoords(Path path, ImageView image) {
    double width = image.getFitWidth();
    double height = image.getFitHeight();

    path.setLayoutX(path.getLayoutX() - width / 2);
    path.setLayoutY(path.getLayoutY() - height / 2);
  }

  /**
   * creates turtle at coordinates specified by turtle object
   *
   * @param newTurtle
   */
  @Override
  public void createTurtle(Turtle newTurtle){
    currentTurtle = newTurtle;
    initialTurtle = newTurtle;
    resetTurtle();
  }

  // create something to animate
  private void createTurtleImage(String turtleImagePath) {
    Image image = new Image(turtleImagePath);
    turtleImage = new ImageView(image);
    turtleImage.setId("turtleImage");
    turtleImage.setFitWidth(TURTLE_SIZE);
    turtleImage.setFitHeight(TURTLE_SIZE);
    turtleImage.getStyleClass().add("turtle-image");
  }

  public Node getTurtleNode() {
    return turtleImage;
  }

  /**
   * Change image for turtle (instead of CSS style's default)
   *
   * @param turtleImage
   */
  @Override
  public void setTurtleImage(Image turtleImage) {
    this.turtleImage.setImage(turtleImage);
  }

  @Override
  public void rotateTurtle() {}

  /**
   * returns current turtle graphic
   *
   * @return
   */
  @Override
  public Image getCurrentTurtleImage() {
    return turtleImage.getImage();
  }

  /** clears screen and resets turtle to original position */
  public void resetTurtle() {
    //makeAnimation(initialTurtle).play();
    turtleImage.setX(initialTurtle.getLocation().getX());
    turtleImage.setX(initialTurtle.getLocation().getY());
  }

}
