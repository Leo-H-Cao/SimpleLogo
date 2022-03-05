package slogo.Backend.TurtleState;

/**
 * This class tests the Lexical Analyzer
 * @author Alex
 * */
public class FieldValue<T> {
  private final T t;

  public FieldValue(T value){
    t = value;
  }

  public T getValue(){
    return t;
  }
}
