public class MarcusOrtizUseCases{

  /**
   * The user attempts to slow down the simulation
   */
  public void useCase1(){
    Turtle turtle = new Turtle(image);
    Slider speedSlider = new Speed();
    int speed = speedSlider.getSlider();
    turtle.setTurtleSpeed(speed);
  }

  /**
   * A person pushes the help button, the key press is not yet in this code
   */
  public void useCase2(){
    Button help = new HelpButton("help");
    Toolbar general = new General();
    general.add(help);
    /// User presses here and activates following code
    help.pushed();
    // This pushed command would use a created help window and use .display() on it to display the screen
  }

  /**
   * An Error pops up for the user
   */
  public void useCase3(){
    Controller.displayError(errorMessage);
    // What will happen is the following code internally
    Window errorWin = new ErrorWindow(errorMessage);
    errorWin.display();
  }
}