package slogo.Backend.SyntaxParser;

public class Product extends ArithmeticOp{
  public Product(Operator op1, Operator op2){
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
  }

  public double getRetVal(){
    return this.arguments.get(0).getRetVal() * this.arguments.get(1).getRetVal();
  }
}
