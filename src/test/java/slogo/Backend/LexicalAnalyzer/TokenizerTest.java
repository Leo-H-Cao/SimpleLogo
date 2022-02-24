package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TokenizerTest {

  @Test
  void getToken() throws InvalidTokenException {
    HashMap<String[], ArrayList<Token>> testPairs = new HashMap<>();
    testPairs.put(
        new String[] {"fd", "50"},
        new ArrayList<Token>(
            List.of(new Token(TokenType.COMMAND, "fd"), new Token(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"FD", "50"},
        new ArrayList<Token>(
            List.of(new Token(TokenType.COMMAND, "FD"), new Token(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"FORWARD", "50"},
        new ArrayList<Token>(
            List.of(new Token(TokenType.COMMAND, "FORWARD"), new Token(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"BACKWARD", "90"},
        new ArrayList<Token>(
            List.of(
                new Token(TokenType.COMMAND, "BACKWARD"), new Token(TokenType.CONSTANT, "90"))));
    testPairs.put(
        new String[] {"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"},
        new ArrayList<Token>(
            List.of(
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "50"),
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "60"),
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "70"),
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "80"),
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "90"))));
    testPairs.put(
        new String[] {"FORWARD", "50", "BACKWARD", "60", "fd", "70", "LEFT", "80", "RIGHT", "90"},
        new ArrayList<Token>(
            List.of(
                new Token(TokenType.COMMAND, "FORWARD"),
                new Token(TokenType.CONSTANT, "50"),
                new Token(TokenType.COMMAND, "BACKWARD"),
                new Token(TokenType.CONSTANT, "60"),
                new Token(TokenType.COMMAND, "fd"),
                new Token(TokenType.CONSTANT, "70"),
                new Token(TokenType.COMMAND, "LEFT"),
                new Token(TokenType.CONSTANT, "80"),
                new Token(TokenType.COMMAND, "RIGHT"),
                new Token(TokenType.CONSTANT, "90"))));
    for (String[] stringTokensArry : testPairs.keySet()) {
      Seq<Tuple2<String, Token>> tokens =
          Seq.of(stringTokensArry).zip(testPairs.get(stringTokensArry));
      for (Tuple2<String, Token> tokenPair : tokens) {
        Token match = Tokenizer.getToken(tokenPair.v1);
        Assertions.assertNotNull(match);
        Assertions.assertInstanceOf(Token.class, match);
        Assertions.assertEquals(match, tokenPair.v2);
      }
    }
  }
}
