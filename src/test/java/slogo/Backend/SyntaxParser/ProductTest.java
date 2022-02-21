package slogo.Backend.SyntaxParser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
  Product myProduct;

  @BeforeEach
  void setup(){
    myProduct = new Product(new Constant(10), new Constant(2));
  }

  @Test
  void testGetRetVal(){
    assertEquals(20.0,myProduct.getRetVal());
  }

  @Test
  void testGetMyNumArgs(){
    assertEquals(2,myProduct.getMyNumArgs());
  }


}
