package slogo.Backend.State;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import slogo.Backend.FileReadingException;
import slogo.Backend.InstructionHistory;
import slogo.Backend.Preferences;
import slogo.Backend.TurtleState.Turtle;
import slogo.BackendExternalAPIs.AccessesState;
import slogo.BackendExternalAPIs.Initialiazable;
import slogo.BackendExternalAPIs.ModifiesModelState;
import slogo.Backend.className;

public class ModelState implements Initialiazable, ModifiesModelState, AccessesState {
  private CommandLanguage commandLanguage;
  private Turtle turtle;
  private Tracks tracks;
  private TurtleHistory History;
  private UserVariables userVariables;
  private UserCommands userCommands;


  /**
   * A method which calls on the backend to get all the tracks created by the Turtle from the
   * perspective of the backend. The returned object can be thought of as a state machine that has
   * all the information on the tracks that the backend knows about.
   *
   * @return Tracks object which has the backend's understanding of the current tracks
   */
  @Override
  public Tracks getTracks() {
    return this.tracks;
  }

  /**
   * Gets history.
   *
   * @return the history
   */
  @Override
  public TurtleHistory getTurtleHistory() {
    return null;
  }

  /**
   * Gets user variables.
   *
   * @return the user variables
   */
  @Override
  public UserVariables getUserVariables() {
    return userVariables;
  }

  /**
   * Gets user commands.
   *
   * @return the user commands
   */
  @Override
  public UserCommands getUserCommands() {
    return userCommands;
  }

  /**
   * Gets instruction history
   *
   * @return the instruction history in the form of an InstructionHistory object
   */
  @Override
  public InstructionHistory getInstructionHistory() {
    return null;
  }

  /**
   * Gets command language.
   *
   * @return the command language
   */
  @Override
  public CommandLanguage getCommandLanguage() {
    return commandLanguage;
  }

  /**
   * @param overrides is the information needed to initialize the backend
   * @return Boolean which is True on initialization success and False otherwise
   */
  @Override
  public ModelState initalizeBackend(Preferences overrides) {
    return null;
  }

  /**
   * This method initializes the backend by telling the model to load files containing a previous
   * state of the backend. It throws a FileNotFoundException if any of the Path objects given do not
   * lead to files.
   *
   * @param state the state
   * @return ModelState object which was initialized by the backend
   * @throws FileNotFoundException is thrown when a file is not found at any of the given Path
   *                               objects
   * @throws FileReadingException  the file reading exception is throw when the file Path objects
   *                               point to files that exist, but the backend is unable to read
   *                               them
   */
  @Override
  public ModelState loadBackendStateFromFiles(HashMap<className, Path> state)
      throws FileNotFoundException, FileReadingException {
    return null;
  }

  /**


  /**
   * Sets command language. See
   * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#toUpperCase() for why
   * toUpperCase(Locale.ENGLISH)
   *
   */
  @Override
  public void setCommandLanguage(String commandLanguage)
      throws IllegalArgumentException, NullPointerException {
    Boolean success = Boolean.FALSE;
    try {
      this.commandLanguage = CommandLanguage.valueOf(commandLanguage.toUpperCase(Locale.ENGLISH));
      success = Boolean.TRUE;
    } catch (IllegalArgumentException | NullPointerException exception) {
      Logger.getGlobal()
          .throwing(
              this.getClass().getName(),
              this.getClass().getEnclosingMethod().toGenericString(),
              exception);
    } catch (Exception exception) {
      Logger.getGlobal()
          .logp(
              Level.SEVERE,
              this.getClass().getName(),
              this.getClass().getEnclosingMethod().toGenericString(),
              "Unexpected exception not in method signature",
              exception);
    }
    return;
  }
}
