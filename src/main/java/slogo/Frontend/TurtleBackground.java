package slogo.Frontend;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TurtleBackground {
  public static final Background DEFAULT_BACKGROUND =
      new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY));

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
}
