package slogo.Backend.LexicalAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RawTokenTest {

  @Test
  void getTyoe() {
    Token t1 = new Token(TokenType.COMMAND, "fd");
    Token t2 = new Token(TokenType.LISTEND, "]");
    Token t3 = new Token(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1.getType(), TokenType.valueOf("COMMAND"));
    Assertions.assertEquals(t2.getType(), TokenType.valueOf("LISTEND"));
    Assertions.assertEquals(t3.getType(), TokenType.valueOf("LISTSTART"));
  }

  @Test
  void getValue() {
    Token t1 = new Token(TokenType.COMMAND, "fd");
    Token t2 = new Token(TokenType.LISTEND, "]");
    Token t3 = new Token(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1.getValue(), "fd");
    Assertions.assertEquals(t2.getValue(), "]");
    Assertions.assertEquals(t3.getValue(), "[");
  }

  @Test
  void testEquals() {
    Token t1 = new Token(TokenType.COMMAND, "fd");
    Token t11 = new Token(TokenType.COMMAND, "fd");
    Token t2 = new Token(TokenType.LISTEND, "]");
    Token t22 = new Token(TokenType.LISTEND, "]");
    Token t3 = new Token(TokenType.LISTSTART, "[");
    Token t33 = new Token(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1, t1);
    Assertions.assertEquals(t2, t2);
    Assertions.assertEquals(t3, t3);
    Assertions.assertEquals(t1, t11);
    Assertions.assertEquals(t2, t22);
    Assertions.assertEquals(t3, t33);
  }

  @Test
  void testHashCode() {
    Token t1 = new Token(TokenType.COMMAND, "fd");
    Token t11 = new Token(TokenType.COMMAND, "fd");
    Token t2 = new Token(TokenType.LISTEND, "]");
    Token t22 = new Token(TokenType.LISTEND, "]");
    Token t3 = new Token(TokenType.LISTSTART, "[");
    Token t33 = new Token(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1.hashCode(), t1.hashCode());
    Assertions.assertEquals(t2.hashCode(), t2.hashCode());
    Assertions.assertEquals(t3.hashCode(), t3.hashCode());
    Assertions.assertEquals(t1.hashCode(), t11.hashCode());
    Assertions.assertEquals(t2.hashCode(), t22.hashCode());
    Assertions.assertEquals(t3.hashCode(), t33.hashCode());
    Assertions.assertNotNull(t1.hashCode());
    Assertions.assertNotNull(t2.hashCode());
    Assertions.assertNotNull(t3.hashCode());
  }
}