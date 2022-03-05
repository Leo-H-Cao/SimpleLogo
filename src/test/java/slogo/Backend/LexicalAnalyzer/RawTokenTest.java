package slogo.Backend.LexicalAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Raw Token Class
 * @author Alex
 * */
class RawTokenTest {

  @Test
  void getTyoe() {
    RawToken t1 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t2 = new RawToken(TokenType.LISTEND, "]");
    RawToken t3 = new RawToken(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1.getType(), TokenType.valueOf("COMMAND"));
    Assertions.assertEquals(t2.getType(), TokenType.valueOf("LISTEND"));
    Assertions.assertEquals(t3.getType(), TokenType.valueOf("LISTSTART"));
  }

  @Test
  void getValue() {
    RawToken t1 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t2 = new RawToken(TokenType.LISTEND, "]");
    RawToken t3 = new RawToken(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1.getValue(), "fd");
    Assertions.assertEquals(t2.getValue(), "]");
    Assertions.assertEquals(t3.getValue(), "[");
  }

  @Test
  void testEquals() {
    RawToken t1 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t11 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t2 = new RawToken(TokenType.LISTEND, "]");
    RawToken t22 = new RawToken(TokenType.LISTEND, "]");
    RawToken t3 = new RawToken(TokenType.LISTSTART, "[");
    RawToken t33 = new RawToken(TokenType.LISTSTART, "[");
    Assertions.assertEquals(t1, t1);
    Assertions.assertEquals(t2, t2);
    Assertions.assertEquals(t3, t3);
    Assertions.assertEquals(t1, t11);
    Assertions.assertEquals(t2, t22);
    Assertions.assertEquals(t3, t33);
  }

  @Test
  void testHashCode() {
    RawToken t1 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t11 = new RawToken(TokenType.COMMAND, "fd");
    RawToken t2 = new RawToken(TokenType.LISTEND, "]");
    RawToken t22 = new RawToken(TokenType.LISTEND, "]");
    RawToken t3 = new RawToken(TokenType.LISTSTART, "[");
    RawToken t33 = new RawToken(TokenType.LISTSTART, "[");
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