package util;

public class TestUtils {
  public static boolean testEqualsWithTolerance(double actualValue, double expectedValue, double tolerance) {
    return actualValue >= expectedValue - tolerance && actualValue <= expectedValue + tolerance;
  }
}
