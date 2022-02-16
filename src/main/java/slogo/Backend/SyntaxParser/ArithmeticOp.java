package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public class ArithmeticOp extends Command {
  private int ArgNum = 2;
  private String type;

  public ArithmeticOp(String type, Command op1, Command op2){
    this.arguments = new ArrayList<Command>();
    this.arguments.add(op1);
    this.arguments.add(op2);
    this.type = type;
  }

  public double getRetVal(){
    switch (type){
      case("sum"):{
        return this.arguments.get(0).getRetVal() + this.arguments.get(1).getRetVal();
      }
      case("difference"):{
        return this.arguments.get(0).getRetVal() - this.arguments.get(1).getRetVal();
      }
      case("product"):{
        return this.arguments.get(0).getRetVal() * this.arguments.get(1).getRetVal();
      }
      case("quotient"):{
        return this.arguments.get(0).getRetVal() / this.arguments.get(1).getRetVal();
      }
      default:{
        //should not get here
        return 0;
      }
    }
  }
}
