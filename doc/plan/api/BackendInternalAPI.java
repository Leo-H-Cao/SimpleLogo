

public Interface BackendInternalAPI{
  public LexResult RunLexicalAnalyzer(String instruction);
  public AST parseCommand(LexResult command);
  public Turtle step(Turtle initialState, AST tree, ASTNode current, int numInstructions);
  public storeTurtle(Turtle c)


    }