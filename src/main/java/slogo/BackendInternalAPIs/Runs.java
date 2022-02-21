package slogo.BackendInternalAPIs;

import java.util.Queue;
import slogo.Backend.LexicalAnalyzer.LexResult;
import slogo.Backend.TurtleState.Turtle;

public interface Runs {

  /**
   * Run lexical analyzer on the user inputted instruction
   * and return the result in the form of a
   * LexResult object
   *
   * @param instruction the String which contains the user inputted instruction
   * @return LexResult object which contains the result of the Lexical Analysis in a form that
   * is understandable by the parser
   */
  LexResult runLexicalAnalyzer(String instruction);

  /**
   * Adds queue of Turtles to History
   * @return True if success, False if failure
   */
  boolean addTurtleQueueToHistory(Queue<Turtle> turtleQueue);

}
