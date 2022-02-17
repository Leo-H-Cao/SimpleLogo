package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainUI {

  private Pane layout;
  private Scene myScene;

  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,800, 800);
    Text title = new Text("SLOGO");
    layout.getChildren().add(title);
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
  }

  public Scene getScene(){
    return myScene;
  }
}
