package slogo.Backend.LexicalAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RawTokenTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"COMMENT","CONSTANT","VARIABLE","COMMAND","LISTSTART","LISTEND"})
    void valueOf(String tokenType) {
      Assertions.assertNotNull(TokenType.valueOf(tokenType));
    }
}
