package slogo.Backend.TurtleState;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class tests the Coordinate class
 * @author Alex
 */
class CoordinateTest {

  @ParameterizedTest
  @CsvSource(
      value = {
        "-9,7", "3,-7", "-3,1", "-3,9", "-2,4", "6,6", "4,5", "-1,-8", "-5,5", "9,2", "0,0", "0,4",
        "3,-7", "-1,2", "5,-1", "1,3", "-7,5", "-2,3", "-5,1", "9,-4"
      })
  void testGetX(double x, double y) {
    Coordinate coordinate = new Coordinate(x, y);
    Assertions.assertEquals(coordinate.getX(), x);
  }

  @ParameterizedTest
  @CsvSource(
      value = {
        "-9,7", "3,-7", "-3,1", "-3,9", "-2,4", "6,6", "4,5", "-1,-8", "-5,5", "9,2", "0,0", "0,4",
        "3,-7", "-1,2", "5,-1", "1,3", "-7,5", "-2,3", "-5,1", "9,-4"
      })
  void testGetY(double x, double y) {
    Coordinate coordinate = new Coordinate(x, y);
    Assertions.assertEquals(coordinate.getY(), y);
  }
}
