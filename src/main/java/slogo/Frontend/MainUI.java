package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.Backend.TurtleState.Turtle;
import slogo.SLogoController;

public class MainUI {
  public static final String DEFAULT_TURTLE_IMAGE_PATH = "test-turtle.png";

  private final SLogoController myController;
  private final BorderPane layout;
  private final Scene myScene;
  private MenuBarUI myMenuBar;
  private ControlPanel myControlPanel;
  private CommandInput myCommandInput;
  private TurtleBackground myTurtleBackground;
  private TurtleView testTurtleView;
  private UserVariablesContainer myUserVariablesContainer;
  private ToolBarUI myToolBar;

  // Might add a reflection thing to talk to a .properties file
  public MainUI(Stage myStage, SLogoController controller) {
    myController = controller;
    layout = new BorderPane();
    myScene = new Scene(layout,800, 800);
    myScene.getStylesheets().add("stylesheet.css");
    createUINodes();
    layout.prefWidthProperty().bind(myScene.widthProperty().multiply(0.80));
    myStage.setResizable(false);
    addStyleClassesToBorderPane();
    addingTurtle();
  }

  public Scene getScene() {
    return myScene;
  }

  public CommandInput getCommandInput() {
    return myCommandInput;
  }

  public TurtleView getTurtleView() {
    return testTurtleView;
  }

  public TurtleBackground getTurtleBackground(){
    return myTurtleBackground;
  }

  public MenuBarUI getMenuBar() {
    return myMenuBar;
  }

  public ControlPanel getControlPanel() {
    return myControlPanel;
  }

  public UserVariablesContainer getUserVariablesContainer(){
    return myUserVariablesContainer;
  }

  private void createUINodes() {
    myMenuBar = new MenuBarUI();
    myControlPanel = new ControlPanel();
    myCommandInput = new CommandInput(myController);
    myTurtleBackground = new TurtleBackground();
    myUserVariablesContainer = new UserVariablesContainer();
    myToolBar = new ToolBarUI();
    layOutChildren();
  }

  private void addingTurtle() {
    testTurtleView = new TurtleView(myControlPanel.getSpeedSlider().getValue(), DEFAULT_TURTLE_IMAGE_PATH);
    myTurtleBackground.addTurtle(testTurtleView);
  }

  private void layOutChildren() {
    Pane layoutTop = new VBox();
    layoutTop.getChildren().addAll(myMenuBar.getMenuBar(), myToolBar.getToolBar());
    layout.setTop(layoutTop);

    layout.setBottom(myCommandInput.getInputBox());
    layout.setRight(myControlPanel.getControlPanelContainer());
    layout.setCenter(myTurtleBackground.getTurtleBackground());
    layout.setLeft(myUserVariablesContainer.getUserVariablesContainer());
  }

  private void addStyleClassesToBorderPane(){
    layout.getLeft().getStyleClass().add("border-pane-left");
    layout.getRight().getStyleClass().add("border-pane-right");
    layout.getBottom().getStyleClass().add("border-pane-bottom");
    layout.getTop().getStyleClass().add("border-pane-top");
  }
}
