package slogo.Backend;

import java.util.Deque;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.TurtleState.Turtle;
import slogo.BackendExternalAPIs.ControlsTurtle;

public class TurtleController implements ControlsTurtle {

  public TurtleController() {}

  /**
   * This methods sends an instruction entered by the user to the backend.
   * <p>
   * If the instruction is "successful" meaning it is syntactically and semantically valid, then
   * this method will return a Deque of Turtle objects which in their totality execute the command
   * from the user by the end of the Deque, but where adjacent Turtle objects in the Deque are
   * separated by one basic command.
   * <p>
   * If the instruction is "unsuccessful," meaning that it is either syntactically and/or
   * semantically invalid or unsuccessful for any other reason, then this method will throw an
   * InvalidTokenException or an instance of one of its subclasses.
   *
   * @param instructionText a String with the instruction text entered by the user to be executed
   * @return Deque<Turtle> which has the Turtle objects created by executing the instruction, each
   * subsequent Turtle object separated by only one basic command.
   */
  @Override
  public Deque<Turtle> postInstruction(String instructionText) throws InvalidTokenException {
    return null;
  }


}
