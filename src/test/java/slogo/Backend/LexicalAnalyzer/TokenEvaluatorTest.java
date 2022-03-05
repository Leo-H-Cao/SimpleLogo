package slogo.Backend.LexicalAnalyzer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TokenEvaluatorTest {

  @ParameterizedTest
  @MethodSource("evaluateTokenArgumentProvider")
  void evaluateToken(RawToken rawToken, Token token) {

  }

  static Stream<Arguments> evaluateTokenArgumentProvider() {
    return Stream.of(
        arguments(new RawToken(null, null), new Token(null, null)),
    );
  }
}