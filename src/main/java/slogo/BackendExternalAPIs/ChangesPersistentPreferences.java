package slogo.BackendExternalAPIs;

import slogo.Backend.Preferences;

/** The interface Changes persistent preferences. */
public interface ChangesPersistentPreferences {

  /**
   * Changes preferences – all preferences in the method paremeter preferencesToChange are changed
   * to the values in that object
   *
   * @param preferencesToChange the preferences to change and the values to change them to
   */
  void changePreferences(Preferences preferencesToChange);
}
