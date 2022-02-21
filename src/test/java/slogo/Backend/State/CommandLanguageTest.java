package slogo.Backend.State;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommandLanguageTest {


  /**
   * Inspiration: https://stackoverflow.com/questions/1079700/how-to-test-enum-types
   */
  @ParameterizedTest
  @CsvSource(value = {"CHINESE","FRENCH","ITALIAN","RUSSIAN","URDU"})
  void valueOf(String language) {
    Assertions.assertNotNull(CommandLanguage.valueOf(language));
  }
}