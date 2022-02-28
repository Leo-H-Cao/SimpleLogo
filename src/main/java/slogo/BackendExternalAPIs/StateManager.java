package slogo.BackendExternalAPIs;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.InstructionHistory;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.Result;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.Tracks;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;

/** The interface Accesses state. */
public interface StateManager {

  /**
   * A method which calls on the backend to get all the tracks created by the Turtle from the
   * perspective of the backend. The returned object can be thought of as a state machine that has
   * all the information on the tracks that the backend knows about.
   *
   * @return Tracks object which has the backend's understanding of the current tracks
   */
  Tracks getTracks();

  /**
   * Gets the full history of the Turtle objects from this running of the model.
   *
   * @return a TurtleHistory object which has the history of where the turtle has been and what state it
   * was in with its Turtle objects, which can be accessed through its public methods
   */
  TurtleHistory getTurtleHistory();

  /**
   * Gets user variables.
   *
   * @return the user variables
   */
  UserVariables getUserVariables();

  /**
   * Gets user commands.
   *
   * @return the user commands
   */
  UserCommands getUserCommands();

  /**
   * Gets instruction history
   *
   * @return the instruction history in the form of an InstructionHistory object
   */
  InstructionHistory getInstructionHistory();

  /**
   * Gets command language.
   *
   * @return the command language
   */
  CommandLanguage getCommandLanguage();

  /**
   * This method sends an instruction entered by the user to the backend.
   *
   * If the instruction is "successful" meaning it is syntactically and semantically valid,
   * then this method will return a Deque of Turtle objects which in their totality execute
   * the command from the user by the end of the Deque, but where adjacent Turtle objects in
   * the Deque are separated by one basic command.
   *
   * If the instruction is "unsuccessful," meaning that it is either syntactically and/or
   * semantically invalid or unsuccessful for any other reason, then this method will throw an
   * InvalidTokenException or an instance of one of its subclasses.
   *
   * @param instructionText a String with the instruction text entered by the user to be executed
   * @return Deque<Turtle> which has the Turtle objects created by executing the instruction, each
   * subsequent Turtle object separated by only one basic command.
   */
  Result postInstruction(String instructionText)
      throws InvalidTokenException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;


}
