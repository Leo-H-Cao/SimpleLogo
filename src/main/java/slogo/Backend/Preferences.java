package slogo.Backend;

import slogo.Backend.State.CommandLanguage;

/**
 * This class represents a collection of user-selectable preferences for an instance of SLogo. It is
 * used for the initialization of a ModelState.
 *
 * @author Edison Ooi
 */
public class Preferences {
  private CommandLanguage language;

  /**
   * Class constructor.
   * @param language the CommandLanguage in which the user wishes to enter commands
   */
  public Preferences(CommandLanguage language) {
    this.language = language;
  }

  /**
   * @return the language in which commands are read
   */
  public CommandLanguage getLanguage() {
    return language;
  }
}
