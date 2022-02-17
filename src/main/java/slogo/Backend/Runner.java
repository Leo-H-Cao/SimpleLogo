package slogo.Backend;

import java.util.Queue;
import slogo.Backend.LexicalAnalyzer.LexResult;
import slogo.BackendInternalAPIs.Runs;

public class Runner implements Runs {

  /**
   * Run lexical analyzer on the user inputted instruction and return the result in the form of a
   * LexResult object
   *
   * @param instruction the String which contains the user inputted instruction
   * @return LexResult object which contains the result of the Lexical Analysis in a form that is
   * understandable by the parser
   */
  @Override
  public LexResult runLexicalAnalyzer(String instruction) {
    return new LexResult(instruction);
  }

  /**
   * Adds queue of Turtles to History
   *
   * @return True if success, False if failure
   */
  public boolean addTurtleQueueToHistory(Queue<Turtle> turtleQueue) {
    return false;
  }
}