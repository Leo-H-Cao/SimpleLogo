package slogo.Frontend;

import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI {

  private Pane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private OutputView myOutput;
  private Sslider mySpeedSlider;

  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,800, 800);
    addingUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    TurtleView testTurtle  = addingTurtle();
    playTurtleAnimation(testTurtle);
  }
  private void addingUINodes(){
    myMenuBar = new MenuBarUI();
    myOutput = new OutputView();
    mySpeedSlider = new SpeedSlider();
    layout.getChildren().add(myMenuBar.getMenuBar());
    layout.getChildren().add(myOutput.getOutputView());
    layout.getChildren().add(mySpeedSlider.getSlider());
  }
  private TurtleView addingTurtle(){
    TurtleView testTurtle = new TurtleView();
    layout.getChildren().add(testTurtle.getTurtleNode());
    return testTurtle;
  }
  private void playTurtleAnimation(TurtleView turtle){
    turtle.makeAnimation().play();
  }

  public Scene getScene(){
    return myScene;
  }
}
