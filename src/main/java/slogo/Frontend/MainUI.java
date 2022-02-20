package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI{

  private Pane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private Sslider mySpeedSlider;
  private CommandInput myCommandInput;

  // Might add a reflection thing to talk to a .properties file
  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,600, 600);
    myScene.getStylesheets().add("stylesheet.css");
    addingUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    TurtleView testTurtle  = addingTurtle();
  }
  private void addingUINodes(){
    myMenuBar = new MenuBarUI();
    mySpeedSlider = new SpeedSlider();
    myCommandInput = new CommandInput();
    layout.getChildren().add(myMenuBar.getMenuBar());
    layout.getChildren().add(mySpeedSlider.getSliderBox());
    layout.getChildren().addAll(myCommandInput.getTextArea(), myCommandInput.getExecuteButton());

  }
  private TurtleView addingTurtle(){
    TurtleView testTurtle = new TurtleView();
    layout.getChildren().add(testTurtle.getTurtleNode());
    return testTurtle;
  }

  public Scene getScene(){
    return myScene;
  }
}
