/**
 * The interface for the frontend external api.
 * Note: Most of interface communicates with Controller not model
 */
public interface FrontendExternalAPI {

  /**
   * Used so the controller can get the input from the text entered for commands
   * for the commands
   * @return (String) - String of the command text that was typed out
   */
  public String getInputText(){

  }
  /**
   *
   */
  public void displayTurtle(){

  }

  /**
   * Controller can set the turtle state for the frontend
   */
  public void putTurtleState(){

  }
  /**
   * Used by the controller to set the style for the document
   * Note: This is not the command to set the different command languages
   * but rather just the style/language of the UI
   * @param interfaceStyle (String) - takes in the name of the style file that is going to be used
   */
  public void setStyle(String interfaceStyle){

  }
  /**
   * This displays the error that the backend tells it to get or the help depending on what subclass object was made
   * @param errorMessage (String) - The error message that is to be displayed to the user
   */
  public void displayError(String message){

  }

  /**
   * This is to set the actual language of the commands, so instead of having repeat, we would have
   * something in say french
   * @param commandLanguage (String) - takes in the name of the language file for the commands
   */
  public void setLanguage(String commandLanguage){
  }

}