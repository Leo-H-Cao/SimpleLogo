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

  /**
   * Turtle background for turtle graphic display
   * @author Leo Cao
   */
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
  public void setBackGroundColor(Color color){
    turtleBackground.setStyle("-fx-background-color: " + toRGBCode(color));
  }

  private String toRGBCode( Color color )
  {
    return String.format( "#%02X%02X%02X",
        (int)( color.getRed() * 255 ),
        (int)( color.getGreen() * 255 ),
        (int)( color.getBlue() * 255 ) );
  }

}
