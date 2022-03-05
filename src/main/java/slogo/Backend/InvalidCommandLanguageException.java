package slogo.Backend;

/**
 * This Exception is thrown whenever an invalid command language - one that does not appear in the
 * CommandLanguage enum - is used.
 *
 * @author Edison Ooi
 */
public class InvalidCommandLanguageException extends Exception {
  public InvalidCommandLanguageException(String message) {
    super(message);
  }
}
