package slogo.BackendExternalAPIs;

public interface ControlsTurtle {
  /**
   * This methods sends an instruction entered by the user to the backend
   *
   * @param instructionText a String with the instruction text entered by the user
   * @return Boolean which represents if the instruction was processed by the backend without issue,
   * True indicates success, False indicates something went wrong.
   */
  public Boolean putInstruction(String instructionText);


  /**
   *
   *
   * @return the next turtle state
   */
  public Turtle getNextTurtleState();

}