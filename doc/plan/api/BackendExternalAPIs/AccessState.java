public interface AccessState {
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

  /**
   * A method which calls on the backend to get all the tracks created by the Turtle
   * from the perspective of the backend. The returned object can be thought of
   * as a state machine that has all the information on the tracks that the backend knows about.
   *
   * @return Tracks object which has the backend's understanding of the current tracks
   */
  public Tracks getTracks();

  /**
   * Gets history.
   *
   * @return the history
   */
  public History getHistory();

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
   * Gets command language.
   *
   * @return the command language
   */
  public CommandLanguage getCommandLanguage();
}