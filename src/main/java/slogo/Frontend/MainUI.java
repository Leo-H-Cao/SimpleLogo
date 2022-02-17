package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI {

  private Pane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;

  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,800, 800);
    myMenuBar = new MenuBarUI();
    layout.getChildren().add(myMenuBar.getMenuBar());
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
  }

  public Scene getScene(){
    return myScene;
  }
}
