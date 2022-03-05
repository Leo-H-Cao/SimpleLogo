package slogo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Utilities {

  public static <T> List<T> dequeToList(Deque<T> deque) {
    List<T> retList = new ArrayList<T>();
    while (!deque.isEmpty()) {
      retList.add(deque.pop());
    }
    return retList;
  }
}