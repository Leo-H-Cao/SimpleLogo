package slogo.Frontend;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import slogo.FrontendExternalAPIs.DisplayCanvas;

public class TurtleBackground implements DisplayCanvas {

  private final Pane turtleBackground;

  public TurtleBackground() {
    turtleBackground = new StackPane();
    turtleBackground.getStyleClass().add("turtle-background");
  }

  public void addTurtle(TurtleView turtle) {
    turtleBackground.getChildren().add(turtle.getTurtleNode());
  }

  public Pane getTurtleBackground() {
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
