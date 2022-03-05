package slogo.Backend.LexicalAnalyzer;
/**
 * This class contains the exception that is thrown if the user inputs tokens that are invalid - the
 * invalidity of a token is determined by the syntax of Slogo ("syntactically invalid") as well as
 * the "semantic" validty - does it mean something valid (for example just because a given String
 * could refer to a valid user defined command doesn't mean it does"
 * @author Alex
 */
public class InvalidTokenException extends Exception {
  public InvalidTokenException(String message) {
    super(message);
  }
}
