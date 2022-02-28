package slogo;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.xml.validation.Validator;
import slogo.Backend.HelpInformation;
import slogo.Backend.Helper;
import slogo.Backend.State.ModelState;
import slogo.Backend.TurtleController;
import slogo.Frontend.CommandInput;
import slogo.Frontend.CommandOutput;
import slogo.Frontend.MainUI;
import slogo.Frontend.TurtleView;
import slogo.Frontend.View;
import slogo.Frontend.ViewUserDefined;

public class SLogoController {
  public static final String SLOGO_PROGRAM_TITLE = "SLogo";

  private ModelState model;
  private Helper helper;
  private TurtleController turtleController;
  private Validator syntaxChecker;

  private View mainView;
  private MainUI gui;
  private CommandInput commandInputter;
  private CommandOutput commandOutputter;
  private TurtleView turtleView;
  private ViewUserDefined userDefinedAttributesUpdater;
  private Stage myStage;

  public SLogoController() {}

  public void setupNewSLogo(Stage stage) {
    // Set up and show stage
    myStage = stage;
    mainView = new View(myStage, this);
    gui = mainView.getMainUI();
    commandInputter = gui.getCommandInput();
    turtleView = gui.getTurtleView();
    userDefinedAttributesUpdater =
        new ViewUserDefined(); // TODO: This should be owned by some class in the frontend

    // initialize window to set parameters
    // frontend stuff to get language + other initial parameters that the backend needs to know
    // resource file will have defaults
    // UI should allow user to change those attributes before starting up the model
    model = new ModelState();
    helper = new Helper();
    turtleController = new TurtleController();
//    syntaxChecker = new Validator();
//    InitializationState initializationState = new InitializationState();
//    model.initalizeBackend(initializationState);

    // initialize turtle
  }

  public void handleKeyInput(KeyCode code) {}

  public void handleCommandSubmitted() {
    String command = commandInputter.getCommands();

    // If it's not valid, do something
//    try{
//      Result turtles = new ControlsTurtle().putInstruction(command);}
//    catch (InvalidTokenException exception){
//      //handle
//    }

  }

  public void handleHelpRequested() {
    HelpInformation help = helper.getHelp(null);
  }
}
