package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.Backend.SyntaxParser.Math.Product;
import slogo.Backend.TurtleState.Turtle;

public class ProductTest {
  Product myProduct;
  private ArrayDeque<Turtle> myTurtleStack;

  @BeforeEach
  void setup() {
    myProduct = new Product(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal() {
    assertEquals(20.0, myProduct.getRetVal());
  }

  @Test
  void testGetMyNumArgs() {
    assertEquals(2, myProduct.getMyNumArgs());
  }
}
