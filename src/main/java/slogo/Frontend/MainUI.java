package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI{

  private Pane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private OutputView myOutput;
  private Sslider mySpeedSlider;
  private CommandInput myCommandInput;

  public MainUI(Stage myStage) {
    layout = new VBox();
    myScene = new Scene(layout,800, 800);
    myScene.getStylesheets().add("stylesheet.css");
    addingUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    TurtleView testTurtle  = addingTurtle();
  }
  private void addingUINodes(){
    myMenuBar = new MenuBarUI();
    myOutput = new OutputView();
    mySpeedSlider = new SpeedSlider();
    myCommandInput = new CommandInput();
    layout.getChildren().add(myMenuBar.getMenuBar());
//    layout.getChildren().add(myOutput.getOutputView());
    layout.getChildren().add(mySpeedSlider.getSlider());
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
