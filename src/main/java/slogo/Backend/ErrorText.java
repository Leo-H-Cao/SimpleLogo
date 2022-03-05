package slogo.Backend;

/**
 * This class is a String representation of an error message, which should be displayed to the user
 * in some form of alert when the program encounters an error.
 *
 * @author Edison Ooi
 */
public class ErrorText {
  private String text;

  /**
   * Class constructor.
   * @param text error message for this error, to be displayed to user
   */
  public ErrorText(String text) {
    this.text = text;
  }

  /**
   * @return String representation of this error message
   */
  public String getText() {
    return text;
  }
}