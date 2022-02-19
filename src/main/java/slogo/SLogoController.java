package slogo;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import slogo.Backend.InitializationState;
import slogo.Backend.ModelState;
import slogo.Frontend.CommandInput;
import slogo.Frontend.CommandOutput;
import slogo.Frontend.MainUI;
import slogo.Frontend.TurtleView;
import slogo.Frontend.View;
import slogo.Frontend.ViewUserDefined;

public class SLogoController {
  public static final String SLOGO_PROGRAM_TITLE = "SLogo";
  private ModelState model;
  private CommandInput commandInputter;
  private CommandOutput commandOutputter;
  private TurtleView turtleView;
  private ViewUserDefined userDefinedAttributesUpdater;
  private Stage myStage;

  public SLogoController(Stage stage) {
    model = new ModelState();
    myStage = stage;
  }

  public void setupNewSLogo() {
    // Set up and show stage
    View mainView = new View(myStage, e -> handleKeyInput(e.getCode()));

    // initialize window to set parameters
    // frontend stuff to get language + other initial parameters that the backend needs to know
    // resource file will have defaults
    // UI should allow user to change those attributes before starting up the model
    InitializationState initializationState = new InitializationState();
    model.initalizeBackend(initializationState);
  }

  public void setupSlogoFromFile() {
    //mutates backend
    //model.loadStateFromFiles();
  }

  private void handleKeyInput(KeyCode code) {

  }

}
