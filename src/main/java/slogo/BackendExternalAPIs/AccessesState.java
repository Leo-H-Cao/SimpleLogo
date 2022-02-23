package slogo.BackendExternalAPIs;

import slogo.Backend.InstructionHistory;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.Tracks;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.State.UserCommands;
import slogo.Backend.State.UserVariables;

/** The interface Accesses state. */
public interface AccessesState {

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


}
