package slogo.Backend;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import slogo.BackendExternalAPIs.AccessState;
import slogo.BackendExternalAPIs.Initializes;
import slogo.BackendExternalAPIs.ModifiesModelState;

public class ModelState implements Initializes, ModifiesModelState, AccessState {
  private CommandLanguage commandLanguage;
  private Turtle turtle;
  private Tracks tracks;
  private History history;
  private UserVariables userVariables;

  /**
   * This method retrives the current Turtle state from the backend. This turtle state is returned
   * in the form of a Turtle object, which has all of the information relevant to the state of the
   * turtle which is relevant to the backend.
   *
   * @return Turtle object with the current turtle state
   */
  @Override
  public Turtle getCurrentTurtleState() {
    return null;
  }

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
  public History getHistory() {
    return history;
  }

  /**
   * Gets user variables.
   *
   * @return the user variables
   */
  @Override
  public UserVariables getUserVariables() {
    return null;
  }

  /**
   * Gets user commands.
   *
   * @return the user commands
   */
  @Override
  public UserCommands getUserCommands() {
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
   * @param info is the information needed to initialize the backend
   * @return Boolean which is True on initialization success and False otherwise
   */
  @Override
  public Boolean initalizeBackend(InitializationState info) {
    return null;
  }

  /**
   * Load state from files boolean.
   *
   * @param state HashMap where keys are enum of Object type to load and values are paths to serialized
   * files of Java Objects
   * @return Boolean which is True on success and False on failure
   */
  @Override
  public Boolean loadStateFromFiles(HashMap<classType, Path> state) {
    return null;
  }

  /**
   * Sets command language.
   * See https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#toUpperCase() for why toUpperCase(Locale.ENGLISH)
   * @return the command language
   */
  @Override
  public Boolean setCommandLanguage(String commandLanguage) throws IllegalArgumentException, NullPointerException{
    Boolean success = Boolean.FALSE;
    try {
      this.commandLanguage = CommandLanguage.valueOf(commandLanguage.toUpperCase(Locale.ENGLISH));
      success = Boolean.TRUE;
    }
    catch (IllegalArgumentException|NullPointerException exception)  {
      Logger.getGlobal().throwing(this.getClass().getName(),
          this.getClass().getEnclosingMethod().toGenericString(),
          exception);
    } catch (Exception exception) {
      Logger.getGlobal().logp(Level.SEVERE, this.getClass().getName(), this.getClass().getEnclosingMethod().toGenericString(), "Unexpected exception not in method signature", exception);
    }
    return success;
  }
}