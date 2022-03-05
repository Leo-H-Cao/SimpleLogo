package slogo.Frontend;

import java.util.Deque;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
  public static final int CANVAS_SIZE = 500;

  private ImageView turtleImage;
  private Turtle currentTurtle;
  private Turtle initialTurtle;
  private double myAnimationSpeed;
  private Canvas canvas;
  private TurtlePen myTurtlePen;

  /**
   * graphical display for turtle and its tracks
   * @param animationSpeed
   * @param turtleImagePath
   */
  public TurtleView(double animationSpeed, String turtleImagePath) {
    createTurtleImage(turtleImagePath);
    myAnimationSpeed = animationSpeed;
    canvas = new Canvas(CANVAS_SIZE,CANVAS_SIZE);
    myTurtlePen = new TurtlePen();
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
    SequentialTransition transition = new SequentialTransition();
    int size = turtles.size();
    for (int i = 0; i < size; i++) {
      Turtle nextTurtle = turtles.pollFirst();
      transition.getChildren().add(makeAnimation(nextTurtle));
      currentTurtle = nextTurtle;
    }
    return transition;
  }

//  private void makeLine(Turtle nextTurtle){
//    double startX = adjustX(currentTurtle.getLocation().getX());
//    double startY = adjustY(currentTurtle.getLocation().getY());
//    double endX = adjustX(nextTurtle.getLocation().getX());
//    double endY = adjustY(nextTurtle.getLocation().getY());
//    Line newLine = myPen.drawLine(startX,endX,startY,endY);
//    penPane.getChildren().add(newLine);
//  }

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
    path.getElements()
        .addAll(
            new MoveTo(adjustX(current.getLocation().getX()), adjustY(-1 * current.getLocation().getY())),
            new LineTo(adjustX(next.getLocation().getX()), adjustY(-1 * next.getLocation().getY())));

    PathTransition pt =
        new PathTransition(Duration.seconds(DEFAULT_SPEED / myAnimationSpeed), path, turtleImage);
    drawLine(pt);

    return pt;
  }

  private void drawLine(PathTransition pt){
    GraphicsContext gc = canvas.getGraphicsContext2D();
    pt.currentTimeProperty().addListener(new ChangeListener<Duration>() {
      Location oldLocation = null;
      /**
       * Draw a line from the old location to the new location
       */
      @Override
      public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
          Duration newValue) {

        // skip starting at 0/0
        if (oldValue == Duration.ZERO) {
          return;
        }

        // get current location
        double x = turtleImage.getTranslateX();
        double y = turtleImage.getTranslateY();

        // initialize the location
        if (oldLocation == null) {
          oldLocation = new Location();
          oldLocation.x = x;
          oldLocation.y = y;
          return;
        }
        // draw line
        myTurtlePen.setGCOptions(gc);
        gc.strokeLine(oldLocation.x + 250, oldLocation.y + 250, x+250, y+250);

        // update old location with current one
        oldLocation.x = x;
        oldLocation.y = y;
      }
    });

  }

  // Adjusts x coordinate to refer to the center of the image instead of the top left corner
  private double adjustX(double actualX) {
    return actualX + turtleImage.getLayoutBounds().getWidth() / 2;
  }

  // Adjusts y coordinate to refer to the center of the image instead of the top left corner
  private double adjustY(double actualY) {
    return actualY + turtleImage.getLayoutBounds().getHeight() / 2;
  }

  // Make a rotate transition from one turtle's direction to another
  private RotateTransition makeRotateTransition(Turtle current, Turtle next) {
    RotateTransition rt = new RotateTransition(Duration.seconds(DEFAULT_SPEED / myAnimationSpeed));
    double angleToRotate = -1 * (next.getDirection().getDirectionInDegrees() - current.getDirection().getDirectionInDegrees());
    rt.setByAngle(angleToRotate);
    return rt;
  }

  public Canvas getCanvas(){
    return canvas;
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

  public TurtlePen getTurtlePen(){
    return myTurtlePen;
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

  public static class Location {
    double x;
    double y;
  }

}
