package slogo.Frontend;

import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.FrontendInternalAPIs.ControlView;

public class MainUI{

  private Pane root;
  private Scene myScene;
  private MenuBarUI myMenuBar;

  public MainUI(Stage myStage) {
    root = new VBox();
    myScene = new Scene(root,800, 800);
    myMenuBar = new MenuBarUI();
    root.getChildren().add(myMenuBar.getMenuBar());
    root.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);

    TurtleView testTurtle = new TurtleView();
    root.getChildren().add(testTurtle.getTurtleNode());
    Animation animation = testTurtle.makeAnimation();
    animation.play();
  }

  public Scene getScene(){
    return myScene;
  }
}
