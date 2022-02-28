package slogo.Frontend;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import slogo.FrontendExternalAPIs.DisplayCanvas;

public class TurtleBackground implements DisplayCanvas {
  private static final Background DEFAULT_BACKGROUND= new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY));

  private final StackPane turtleBackground;

  public TurtleBackground() {
    turtleBackground = new StackPane();
    turtleBackground.setBackground(DEFAULT_BACKGROUND);
  }

  public void addTurtle(TurtleView turtle) {
    turtleBackground.getChildren().add(turtle.getTurtleNode());
  }

  public StackPane getTurtleBackground() {
    return turtleBackground;
  }

  /**
   * clears screen and resets turtle to original position
   */
  public void resetDisplay(){}

  /**
   * changes background color
   */
  public void setBackGroundColor(){}

}
