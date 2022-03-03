package slogo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import slogo.Backend.ErrorText;
import slogo.Backend.HelpInformation;
import slogo.Backend.Helper;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.Result;
import slogo.Backend.State.ModelState;
import slogo.Backend.TurtleState.Turtle;
import slogo.Frontend.CommandInput;
import slogo.Frontend.CommandOutput;
import slogo.Frontend.MainUI;
import slogo.Frontend.TurtleView;
import slogo.Frontend.View;
import slogo.Frontend.ViewUserDefined;

/**
 * This class represents the controller, or the intermediary between the model and view components
 * of an instance of SLogo. This class is the birthplace of a SLogo instance, and is responsible for
 * instantiation and initialization of all objects tied to a particular SLogo instance, and will
 * persist these objects for its entire lifespan.
 * <p>
 * This class contains functionality to handle user interactions that require mutation of both
 * frontend and backend components, for example, inputting and executing a command.
 *
 * @author Edison Ooi
 */
public class SLogoController {

  // Backend objects
  private ModelState model;
  private Helper helper;
  private static final int[] INITIAL_POSITION = new int[]{0, 0};
  private static final double INITIAL_DIRECTION = Math.PI / 2;
  private static final boolean INITIAL_PENDOWN = true;
  public static final Turtle INITIAL_TURTLE = new Turtle(INITIAL_POSITION, INITIAL_DIRECTION, INITIAL_PENDOWN);

  // Frontend objects
  private View mainView;
  private MainUI gui;
  private CommandInput commandInputter;
  private CommandOutput commandOutputter;
  private TurtleView turtleView;
  private ViewUserDefined userDefinedAttributesUpdater;
  private Stage myStage;

  /**
   * Class constructor.
   */
  public SLogoController() {
  }

  /**
   * Sets up a new instance of SLogo. Instantiates all necessary frontend and backend objects
   * necessary to run SLogo, and ties them to this particular controller instance to prevent
   * arbitrary creation of such objects later on in execution.
   * <p>
   * This method should be the first method called after instantiation of a new SLogoController.
   *
   * @param stage Stage object responsible for displaying the program
   */
  public void setupNewSLogo(Stage stage) {
    // Initialize UI components
    myStage = stage;
    mainView = new View(myStage, this);

    gui = mainView.getMainUI();

    commandInputter = gui.getCommandInput();
    commandOutputter = gui.getCommandOutput();

    turtleView = gui.getTurtleView();
    turtleView.createTurtle(INITIAL_TURTLE);
    turtleView.resetTurtle();

    userDefinedAttributesUpdater =
        new ViewUserDefined(); // TODO: This should be owned by some class in the frontend

    // initialize window to set parameters
    // frontend stuff to get language + other initial parameters that the backend needs to know
    // resource file will have defaults
    // UI should allow user to change those attributes before starting up the model

    // ModelState owns command language, turtle, tracks, history, and user variables/commands
    model = new ModelState();

    // Independent object that fetches help for user (just a string for now)
    helper = new Helper();

    // initialize turtle
  }

  /**
   * Performs the appropriate actions upon some desired keystroke.
   *
   * @param code KeyCode of key that was pressed.
   */
  public void handleKeyInput(KeyCode code) {
  }

  /**
   * Sends user-inputted command from frontend to backend, and if successfully executed, will return
   * the result of that command (a numeric return value or a new turtle state) back to the frontend
   * to update the GUI.
   * <p>
   * This method should only be called whenever a user performs an action that indicates they are
   * trying to execute a command.
   */
  public void handleCommandSubmitted() {
    String command = commandInputter.getCommands();

    try {
      Result commandResult = model.postInstruction(command);
      ArrayDeque<Turtle> steps = commandResult.getTurtleSteps();
      if (steps == null || steps.size() <= 1) {
        commandOutputter.displayResult(commandResult);
      } else {
        turtleView.moveTurtle(steps.clone());
      }
    } catch (InvalidTokenException | ClassNotFoundException | InvocationTargetException |
        NoSuchMethodException | InstantiationException | IllegalAccessException exception) {
      //handle
      System.out.println(exception);
      commandOutputter.displayError(new ErrorText(exception.toString()));
    }
  }

  /**
   * Queries backend helper object to return either specified or generic program help information,
   * and returns it back to the frontend to display to the user.
   * <p>
   * This method should only be called whenever a user performs an action that indicates they are
   * requesting help.
   */
  public void handleHelpRequested() {
    HelpInformation help = helper.getHelp(null);
    if (help != null) {
      // display the help to the frontend
    }
  }

}
