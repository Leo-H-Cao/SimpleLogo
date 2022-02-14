public interface Parses {
  /**
   * Parse a user created instruction into an AST.
   *
   * @param command is the user inputted command after it was ran through the lexical analyzer
   * @return an AST object which represents the abstract sytax tree of the initial user inputted command
   */
  public AST parseCommand(LexResult command);
}

