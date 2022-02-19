package slogo.Backend.SyntaxParser;


public class Sum extends ArithmeticOp{
  public Sum(Operator op1, Operator op2){
    super();
    this.arguments.add(op1);
    this.arguments.add(op2);
  }

  public double getRetVal(){
    return this.arguments.get(0).getRetVal() + this.arguments.get(1).getRetVal();
  }
}

