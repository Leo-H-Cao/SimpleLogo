/**
 * Interface for the frontend internal api
 */
public interface FrontendInternalAPI {
  /**
   * Used to display a window when a button is clicked
   * this will just lead to a static reference page
   * of the initial commands available
   */
  public void display(){

  }

  /**
   * Used to adjust the speed of the animations, this will be done by adjusting the speed of drawing for a single command, the way to change the speed would be in the UI
   */
  public void setSpeed(int speed){

  }

  /**
   * Used to create the different buttons for the display
   * @param buttonType (String) - defines the type of button, plan is to have Button as a superclass and then
   *                              have the individual buttons be the
   * @return Button - an instance of the type of button that was requested
   */
  public Button createButton(String buttonType){

  }

  /**
   * Creates a tool bar for the display
   * @param buttons - any buttons or tabs that are going to be shown in the bar
   * @param sliders - any sliders that are going to be shown in the bar
   * @return Toolbar - the toolbar that holds all these items in its box
   */
  public Toolbar createToolbar(List<Button> buttons, List<Slider> sliders){

  }

  /**
   * Creating a sliding bar of the type passed
   * @param sliderType (String) - the type of slider you want
   * @return Slider - the slider with the specific instance of the type
   */
  public Slider createSlider(String sliderType){

  }

  /**
   * Creates an input box for the user
   * @return - an input box for the user to type in
   */
  public InputBox createInputBox(){

  }
  // Abstract method that decides what happens when a button is pushed
  public abstract void pushed();
  // Sets the slider position using an int
  public void setSlide(int x){

  }
  // get the slider position as an int
  public int getSlide(){

  }
  // Sets the speed of the turtle object
  public void setTurtleSpeed(int speed){

  }
}