package slogo.BackendExternalAPIs;

import slogo.Backend.InvalidCommandLanguageException;

public interface ModifiesModelState {
  /**
   * Sets command language to commandLanguage
   *
   * @param commandLanguage the command language to set to
   * @throws InvalidCommandLanguageException is thrown when commandLanguage does not refer to a valid command language
   */
  void setCommandLanguage(String commandLanguage) throws InvalidCommandLanguageException;
}
