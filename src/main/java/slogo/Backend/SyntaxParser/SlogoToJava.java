package slogo.Backend.SyntaxParser;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class handles converting commands from their names in the Slogo language to
 * their Java class names. This allows flexibility in having Java Class names not need
 * to align with Slogo command names
 */
public class SlogoToJava {
  private static final Map<String,String> conversionMap = SlogoToJava.loadConversionMap();

  private static Map<String, String> loadConversionMap() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("slogo/SlogoToJava");
    Map<String,String> conversion = new HashMap<>();
    for (String slogoName: resourceBundle.keySet()) {
      conversion.put(slogoName, resourceBundle.getString(slogoName));
    }
    return conversion;
  }

  public static String convertSlogoNameToJavaName(String slogoName) {
    return SlogoToJava.conversionMap.getOrDefault(slogoName, slogoName);
  }

}
