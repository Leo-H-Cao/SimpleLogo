package slogo.BackendExternalAPIs;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.Result;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;

/**
 * This interface indicates that the implementing class can be used to access data in the model's state
 * @author Alex
 */
public interface StateManager {


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
