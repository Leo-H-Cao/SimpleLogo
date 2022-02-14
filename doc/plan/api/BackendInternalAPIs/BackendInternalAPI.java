/**
 * The interface backend internal api.
 */
public interface BackendInternalAPI {

  /**
   * This method handles the flow of control for the process
   * of handling a new instruction from the user. It will deal with
   * calling the necessary steps in the process of executing an instruction.
   * @param instruction a String which contains the user inputted instruction which needs to be executed.
   */
  public void instructionRunner(String instruction);

  /**
   * Run lexical analyzer on the user inputted instruction
   * and return the result in the form of a
   * LexResult object
   *
   * @param instruction the String which contains the user inputted instruction
   * @return LexResult object which contains the result of the Lexical Analysis in a form that
   * is understandable by the parser
   */
  public LexResult runLexicalAnalyzer(String instruction);

  /**
   * Parse a user created instruction into an AST.
   *
   * @param command is the user inputted command after it was ran through the lexical analyzer
   * @return an AST object which represents the abstract sytax tree of the initial user inputted command
   */
  public AST parseCommand(LexResult command);

  /**
   * Iterate through the AST for numInstructions instructions and return the final turtle state
   *
   * @param initialState    the initial turtle state
   * @param tree            the abstract syntax tree
   * @param current         the current instruction
   * @param numInstructions the number of instructions to execute
   * @return the turtle in its final state
   */
  public Turtle step(Turtle initialState, AST tree, ASTNode current, int numInstructions);

  /**
   * Add turtle to history of turtles. .
   *
   * @param current the turtle to be added
   * @return true if the addition was sucessful, false if an error occured (e.g. stack overflow)
   */
  public Boolean addTurtleToHistory(Turtle current);
}