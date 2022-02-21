package slogo.Backend;

import java.util.Queue;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.LexicalAnalyzer.LexResult;
import slogo.Backend.SyntaxParser.ASTMaker;
import slogo.Backend.SyntaxParser.Operator;
import slogo.Backend.TurtleState.Turtle;
import slogo.BackendInternalAPIs.Parses;
import slogo.BackendInternalAPIs.Runs;

public class Runner implements Runs, Parses {

  public double run(String instruction) throws InvalidTokenException {
    LexResult lexResult = new LexResult(instruction);
    ASTMaker ast = new ASTMaker(lexResult.getTokens());
    Operator operator = ast.parse();
    double retValue = operator.getRetVal();
    return retValue;
  }

  /**
   * Run lexical analyzer on the user inputted instruction and return the result in the form of a
   * LexResult object
   *
   * @param instruction the String which contains the user inputted instruction
   * @return LexResult object which contains the result of the Lexical Analysis in a form that is
   * understandable by the parser
   */
  @Override
  public LexResult runLexicalAnalyzer(String instruction) throws InvalidTokenException {
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

  /**
   * Parse a user created instruction into an AST.
   *
   * @param command is the user inputted command after it was ran through the lexical analyzer
   * @return an AST object which represents the abstract sytax tree of the initial user inputted
   * command
   */
  @Override
  public AST parseCommand(LexResult command) {
    return null;
  }
}