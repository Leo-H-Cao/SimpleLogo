package slogo.Frontend;

import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI {

  private Pane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private OutputView myOutput;

  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,800, 800);
    myMenuBar = new MenuBarUI();
    myOutput = new OutputView();
    layout.getChildren().add(myMenuBar.getMenuBar());
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);

    TurtleView testTurtle = new TurtleView();
    layout.getChildren().add(testTurtle.getTurtleNode());
    Animation animation = testTurtle.makeAnimation();
    animation.play();
  }
  private void addingLayoutNodes(){
    myMenuBar = new MenuBarUI();
    myOutput = new OutputView();
    layout.getChildren().add(myMenuBar.getMenuBar());
    layout.getChildren().add(myOutput.getOutputView());
  }

  public Scene getScene(){
    return myScene;
  }
}
