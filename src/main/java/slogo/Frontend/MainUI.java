package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import slogo.SLogoController;

public class MainUI{

  private SLogoController myController;
  private BorderPane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private ControlPanel myControlPanel;
  private CommandInput myCommandInput;
  private TurtleBackground myTurtleBackground;
  private TurtleView testTurtle;

  // Might add a reflection thing to talk to a .properties file
  public MainUI(Stage myStage, SLogoController controller) {
    myController = controller;
    layout = new BorderPane();
    myScene = new Scene(layout,600, 600);
    myScene.getStylesheets().add("stylesheet.css");
    createUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    addStyleClassesToBorderPane();
    addingTurtle();
  }

  public Scene getScene(){
    return myScene;
  }

  private void createUINodes(){
    myMenuBar = new MenuBarUI();
    myControlPanel = new ControlPanel();
    myCommandInput = new CommandInput(myController);
    myTurtleBackground = new TurtleBackground();
    layOutChildren();
  }
  private void addingTurtle(){
    testTurtle = new TurtleView();
    myTurtleBackground.addTurtle(testTurtle);
  }

  private void layOutChildren(){
    layout.setTop(myMenuBar.getMenuBar());
    layout.setBottom(myCommandInput.getInputBox());
    layout.setRight(myControlPanel.getControlPanelContainer());
    layout.setCenter(myTurtleBackground.getTurtleBackground());
  }

  private void addStyleClassesToBorderPane(){
//    layout.getLeft().getStyleClass().add("border-pane-left");
    layout.getRight().getStyleClass().add("border-pane-right");
    layout.getBottom().getStyleClass().add("border-pane-bottom");
    layout.getTop().getStyleClass().add("border-pane-top");
  }

  public CommandInput getCommandInput(){
    return myCommandInput;
  }

  public TurtleView getTurtleView(){
    return testTurtle;
  }


}
