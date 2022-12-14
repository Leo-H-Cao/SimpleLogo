public class AlexBildnerUseCases {

  /**
   * This usecase indicates how our program would handle checking if the program
   * was currently using English as the commmand language and if it was, changing the
   * command language to French
   */
  public void firstUseCase()  {
    CommandLanguage lang = AccessState.getCommandLanguage();
    if(lang.equals(CommandLanguage.ENGLISH)){
      ModelState.setCommandLanguage(CommandLanguage.FRENCH);
    }
  }

  /**
   * This usecase indicates how our program's controller would handle checking the correctness
   * of the syntax of a user entered instruction, and upon realizing the incorrect syntax
   * of this instruction, getting the error message and sending it to the Display
   */
  public void secondUseCase(String instruc)  {
    ValidityResult valid = Validator.checkValidity(instruc);
    if (!ValidityResult)  {
      ErrorText text = Validator.getErrorText();
      displayError(text);
    }
  }

  /**
   * This usecase indicates how our program would handle getting the current command language
   * of the program, getting the command history of the program, and getting the user defined
   * variables of the program – and then printing all of these to the console (perhaps for
   * debugging purposes).
   */
  public void thirdUseCase()  {
    CommandLanguage lang = AccessState.getCommandLanguage();
    History commandHistory = ModelState.getHistory();
    UserVariables vars = ModelState.getUserVariables();
    System.out.println(lang);
    System.out.println(commandHistory);
    System.out.println(vars);
  }
}