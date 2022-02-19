package slogo.Backend.SyntaxParser;

public class Main {

  public static void main(String[] args) {
    ArithmeticOp op1 = new Difference(new Constant(10), new Constant(1));
    ArithmeticOp op2 = new Difference(new Constant(10), new Constant(1));
    ArithmeticOp root = new Sum(op1, op2);
    System.out.println(root.getRetVal());


    //using tokens
    /*
    ASTMaker tree = new ASTMaker(ArrayDeque<Token> tokens);
    Operator root = tree.parse();
    System.out.println(root.getRetVal()); //this will execute the commands
     */
  }
}
