package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import slogo.Backend.SyntaxParser.Command;

public class MainUI{

  private BorderPane layout;
  private Scene myScene;
  private MenuBarUI myMenuBar;
  private ControlPanel myControlPanel;
  private CommandInput myCommandInput;

  // Might add a reflection thing to talk to a .properties file
  public MainUI(Stage myStage) {
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
    layout.setRight(myControlPanel.getControlPanelContainer());
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


}
