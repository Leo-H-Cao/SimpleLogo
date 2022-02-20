package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainUI{

  private BorderPane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private Sslider mySpeedSlider;
  private CommandInput myCommandInput;

  // Might add a reflection thing to talk to a .properties file
  public MainUI(Stage myStage) {
    layout = new BorderPane();
    myScene = new Scene(layout,600, 600);
    myScene.getStylesheets().add("stylesheet.css");
    createUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    addingTurtle();
  }
  private void createUINodes(){
    myMenuBar = new MenuBarUI();
    mySpeedSlider = new SpeedSlider();
    myCommandInput = new CommandInput();
    layOutChildren();
  }
  private TurtleView addingTurtle(){
    TurtleView testTurtle = new TurtleView();
    layout.setCenter(testTurtle.getTurtleNode());
    return testTurtle;
  }

  private void layOutChildren(){
    layout.setTop(myMenuBar.getMenuBar());
    layout.setBottom(myCommandInput.getInputBox());
    layout.setRight(mySpeedSlider.getSlider());
  }

  public Scene getScene(){
    return myScene;
  }
}
