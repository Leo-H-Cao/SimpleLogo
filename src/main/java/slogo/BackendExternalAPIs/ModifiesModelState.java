package slogo.BackendExternalAPIs;

import slogo.Backend.InvalidCommandLanguageException;

/**
 * This class indicates that the implementing class can modify the model state
 * @author Alex
 */
public interface ModifiesModelState {
  /**
   * Sets command language to commandLanguage
   *
   * @param commandLanguage the command language to set to
   * @throws InvalidCommandLanguageException is thrown when commandLanguage does not refer to a valid command language
   */
  void setCommandLanguage(String commandLanguage) throws InvalidCommandLanguageException;
}
