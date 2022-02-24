package slogo.Frontend;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * @author Robert Duvall This utility class was pulled from the spike slogo repository and was not
 *     written by this team
 */
public class ResourceUtil {
  private static final String ERROR_MESSAGE = "Property %s is not a %s: %s";

  /**
   * Returns value of given resource as a number or throws an exception.
   *
   * <p>NOTE, given resource value must represent a non-negative integer
   */
  public static int getResourceNumber(ResourceBundle resources, String key)
      throws InputMismatchException {
    // regular expression that matches a complete string containing one or more digits
    final String POSITIVE_NUMBER_PATTERN = "^\\d+$";

    String number = resources.getString(key).trim();
    if (number.matches(POSITIVE_NUMBER_PATTERN)) {
      return Integer.parseInt(number);
    } else {
      throw new InputMismatchException(String.format(ERROR_MESSAGE, key, "number", number));
    }
  }

  /**
   * Returns value of given resource as a JFX color or throws an exception.
   *
   * <p>NOTE, given resource value must represent the exact constant name in all capitals
   */
  public static Paint getResourceColor(ResourceBundle resources, String key)
      throws InputMismatchException {
    String color = resources.getString(key).trim();
    try {
      // note, get() parameter is null because it is a static value (no instance needed)
      return (Paint) Color.class.getField(color.toUpperCase()).get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new InputMismatchException(String.format(ERROR_MESSAGE, key, "color", color));
    }
  }

  /**
   * Returns value of given resource as a number or throws an exception.
   *
   * <p>NOTE, given resource value must represent the entire class name, including all packages
   */
  public static Shape getResourceShape(
      ResourceBundle resources, String key, int x, int y, int width, int height)
      throws InputMismatchException {
    String shape = resources.getString(key).trim();
    try {
      // convert string into Java object that represents that Java class
      Class<?> clazz = Class.forName(shape);
      // use reflection to find the appropriate constructor of that class to call to create a new
      // instance
      Constructor<?> ctor =
          clazz.getDeclaredConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
      return (Shape) ctor.newInstance(x, y, width, height);
    } catch (ClassNotFoundException
        | InvocationTargetException
        | NoSuchMethodException
        | InstantiationException
        | IllegalAccessException e) {
      throw new InputMismatchException(String.format(ERROR_MESSAGE, key, "shape", shape));
    }
  }
}
