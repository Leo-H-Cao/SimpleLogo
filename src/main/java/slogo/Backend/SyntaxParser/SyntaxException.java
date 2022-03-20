package slogo.Backend.SyntaxParser;

/**
 * This class is the Exception thrown for user inputted syntax errors
 */
public class SyntaxException extends Exception{
  public SyntaxException(String message) {
    super(message);
  }
}
