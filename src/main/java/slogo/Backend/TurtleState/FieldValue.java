package slogo.Backend.TurtleState;

/**
 * This class is used for holding data field values for use in Turtle transformations and to allow
 * for type flexibility in Collections
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
