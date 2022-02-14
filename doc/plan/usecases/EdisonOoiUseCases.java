public class EdisonOoiUseCases {

  /**
   * Put an instruction that tells the turtle to move to the left and retrive an AST from it.
   */
  public void useCase1(String instruction) {
    Runner runner = new Runner();
    LexResult result = runner.runLexicalAnalyzer(instruction);
    Parser parser = new Parser();
    AST tree = parser.parseCommand(result);
  }

  /**
   * Put a faulty instruction and display the resulting error text
   */
  public void useCase2(String badInstruction) {
    Runner runner = new Runner();
    LexResult result = runner.runLexicalAnalyzer(instruction);
    CheckSyntax c = new ImplementationOfCheckSyntax();

    FrontendExternalAPI.displayError(c.getErrorText());
  }

  public void useCase3() {

  }
}