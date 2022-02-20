package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<Operator> list1 = new ArrayList<Operator>();
    list1.add(new Constant(10));
    list1.add(new Constant(1));
    ArrayList<Operator> list2 = new ArrayList<Operator>();
    list2.add(new Constant(10));
    list2.add(new Constant(1));
    ArithmeticOp op1 = new Difference(list1);
    ArithmeticOp op2 = new Difference(list2);
    ArrayList<Operator> list3 = new ArrayList<Operator>();
    list3.add(op1);
    list3.add(op2);
    ArithmeticOp root = new Sum(list3);
    System.out.println(root.getRetVal());


    //using tokens
    /*
    ASTMaker tree = new ASTMaker(ArrayDeque<Token> tokens);
    Operator root = tree.parse();
    System.out.println(root.getRetVal()); //this will execute the commands
     */
  }
}
