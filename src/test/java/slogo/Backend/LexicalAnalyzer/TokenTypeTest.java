package slogo.Backend.LexicalAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class tests the Token Type class
 * @author Alex
 * */
class TokenTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"COMMENT","CONSTANT","VARIABLE","COMMAND","LISTSTART","LISTEND", "GROUPSTART", "GROUPSTART"})
    void valueOf(String tokenType) {
      Assertions.assertNotNull(TokenType.valueOf(tokenType));
    }
}
