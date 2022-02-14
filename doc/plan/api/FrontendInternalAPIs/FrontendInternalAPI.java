/**
 * Interface for the frontend internal api
 */
public interface FrontendInternalAPI {
  /**
   * Used to display a help message when a button is clicked
   * this will just lead to a static reference page
   * of the initial commands available
   */
  private void displayHelp(){

  }

  /**
   * Used to adjust the speed of the animations, this will be done by adjusting the speed of drawing for a single command, the way to change the speed would be in the UI
   */
  private void setSpeed(int speed){

  }

  /**
   * Used to create the different buttons for the display
   * @param buttonType (String) - defines the type of button, plan is to have Button as a superclass and then
   *                              have the individual buttons be the
   * @return
   */
  private Button createButton(String buttonType){

  }
  private Toolbar createToolbar(List<Button> buttons, List<Slider> sliders){

  }
  private Slider createSlider(){

  }
  private InputBox createInputBox(){

  }
  private

}