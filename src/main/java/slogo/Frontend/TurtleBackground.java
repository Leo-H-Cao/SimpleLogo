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

  private final Pane turtleBackground = new StackPane();
  private TurtleView currentTurtleView;

  public TurtleBackground() {
    turtleBackground.getStyleClass().add("turtle-background");
  }

  public void addTurtle(TurtleView turtle) {
    currentTurtleView  = turtle;
    turtleBackground.getChildren().addAll(turtle.getCanvas(), turtle.getTurtleNode());
  }

  public Pane getTurtleBackground() {
    return turtleBackground;
  }

  /**
   * clears screen and resets turtle to original position
   */
  @Override
  public void resetDisplay(){
    currentTurtleView.resetTurtle();
  }

  /**
   * changes background color
   */
  @Override
  public void setBackGroundColor(){}

}
