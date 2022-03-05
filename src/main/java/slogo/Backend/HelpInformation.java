package slogo.Backend;

/**
 * This class contains the String representation of the help requested by a user.
 *
 * @author Edison Ooi
 */
public class HelpInformation {
  private String info;

  /**
   * Class constructor.
   * @param info String representing help info
   */
  public HelpInformation(String info) {
    this.info = info;
  }

  /**
   * @return String representing help info
   */
  protected String getInfo() {
    return info;
  }
}
