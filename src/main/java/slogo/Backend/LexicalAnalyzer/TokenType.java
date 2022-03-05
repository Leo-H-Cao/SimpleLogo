package slogo.Backend.LexicalAnalyzer;
/**
 * This class has the various types of Tokens in the Slogo language defined
 * according to the syntax in the Slogo properties files
 * @author Alex
 */
public enum TokenType {
  COMMENT,
  CONSTANT,
  VARIABLE,
  COMMAND,
  LISTSTART,
  LISTEND,
  GROUPEND,
  GROUPSTART
}
