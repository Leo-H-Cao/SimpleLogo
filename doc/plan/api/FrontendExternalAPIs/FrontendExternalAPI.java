/**
 * The interface for the frontend external api.
 * Note: Most of interface communicates with Controller not model
 */
public interface FrontendExternalAPI {

  /**
   * Used so the controller can get the input from the text entered
   * for the commands
   */
  public String getInputText(){

  }

  /**
   *
   */
  public displayTurle(){

  }

  /**
   *
   */
  public putTurtleState(){

  }
  /**
   * Used by the controller to set the style for the document
   * Note: This is not the command to set the different command languages
   * but rather just the style/language of the UI
   */
  public void setStyle(String interfaceStyle){

  }

  /**
   * Backend will use this to tell the frontend the error it needs
   * to display on a screen
   */
  public void putError(String errorMessage){

  }

  /**
   * This is to set the actual language of the thing that
   */
  public void setLanguage(String commandLanguage){
  }

}