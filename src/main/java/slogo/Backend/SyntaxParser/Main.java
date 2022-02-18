package slogo.Backend.SyntaxParser;

public class Main {

  public static void main(String[] args) {
    // write your code here
    ArithmeticOp op1 = new ArithmeticOp("difference", new Constant(10), new Constant(1));
    ArithmeticOp op2 = new ArithmeticOp("difference", new Constant(10), new Constant(1));
    ArithmeticOp root = new ArithmeticOp("product", op1, op2);
    System.out.println(root.getRetVal());
  }
}
