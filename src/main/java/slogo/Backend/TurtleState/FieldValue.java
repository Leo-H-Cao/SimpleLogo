package slogo.Backend.TurtleState;

public class FieldValue<T> {
  private final T t;

  public FieldValue(T value){
    t = value;
  }

  public T getValue(){
    return t;
  }
}
