package slogo.Backend.SyntaxParser;


import java.util.ArrayList;

public class Quotient extends ArithmeticOp{
  public Quotient(ArrayList<Operator> operands){
    super();
    this.arguments.add(operands.get(0));
    this.arguments.add(operands.get(1));
  }

  public double getRetVal(){
    return this.arguments.get(0).getRetVal() / this.arguments.get(1).getRetVal();
  }
}
