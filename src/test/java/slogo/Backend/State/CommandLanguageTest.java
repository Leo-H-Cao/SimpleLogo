package slogo.Backend.State;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class tests the Command Languages
 * @author Alex
 */
class CommandLanguageTest {

  /** Inspiration: https://stackoverflow.com/questions/1079700/how-to-test-enum-types */
  @ParameterizedTest
  @CsvSource(value = {"CHINESE", "FRENCH", "ITALIAN", "RUSSIAN", "URDU"})
  void valueOf(String language) {
    Assertions.assertNotNull(CommandLanguage.valueOf(language));
  }
}
