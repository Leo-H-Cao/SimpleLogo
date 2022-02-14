public interface Steps {
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