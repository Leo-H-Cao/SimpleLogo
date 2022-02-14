/**
 * The interface Backend external api.
 */
public interface BackendExternalAPI {

  /**
   * This method retrives the current Turtle state
   * from the backend. This turtle state is returned
   * in the form of a Turtle object, which has all
   * of the information relevant to the state of the
   * turtle which is relevant to the backend.
   *
   * @return Turtle object with the current turtle state
   */
  public Turtle getCurrentTurtleState();

  public Boolean initalizeBackend(InitializationState info);

  /**
   * This methods sends an instruction entered by the user to the backend
   *
   * @param instructionText a String with the instruction text entered by the user
   * @return Boolean which represents if the instruction was processed by the backend without issue,
   * True indicates success, False indicates something went wrong.
   */
  public Boolean putInstruction(String instructionText);

  /**
   * A method which calls on the backend to get all the tracks created by the Turtle
   * from the perspective of the backend. The returned object can be thought of
   * as a state machine that has all the information on the tracks that the backend knows about.
   *
   * @return Tracks object which has the backend's understanding of the current tracks
   */
  public Tracks getTracks();

  /**
   *
   *
   * @return the next turtle state
   */
  public Turtle getNextTurtleState();

  /**
   * Gets help.
   *
   * @return the help
   */
  public HelpInfo getHelp();

  /**
   * Gets history.
   *
   * @return the history
   */
  public History getHistory();

  /**
   * Load state from files boolean.
   *
   * @return the boolean
   */
  public Boolean loadStateFromFiles(HashMao<Class, Path>);

  /**
   * Gets command language.
   *
   * @return the command language
   */
  public CommandLanguage getCommandLanguage();

  /**
   * Sets command language.
   *
   * @return the command language
   */
  public Boolean setCommandLanguage();

  /**
   * Gets user variables.
   *
   * @return the user variables
   */
  public UserVariables getUserVariables();

  /**
   * Gets user commands.
   *
   * @return the user commands
   */
  public UserCommands getUserCommands();

  /**
   * Check validity validity result.
   *
   * @param instruction the instruction
   * @return the validity result
   */
  public ValidityResult checkValidity(String instruction);

  /**
   * Gets error text.
   *
   * @return the error text
   */
  public ErrorText getErrorText();
