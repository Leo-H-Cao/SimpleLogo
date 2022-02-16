package slogo.Backend.Parser;

import java.util.ArrayList;

public class Operation extends Command {
  private int ArgNum = 2;
  private String type;

  public Operation(String type, Command op1, Command op2){
    this.arguments = new ArrayList<Command>();
    this.arguments.add(op1);
    this.arguments.add(op2);
    this.type = type;
  }

  public double getRetVal(){
    switch (type){
      case("add"):{
        return this.arguments.get(0).getRetVal() + this.arguments.get(1).getRetVal();
      }
      case("sub"):{
        return this.arguments.get(0).getRetVal() - this.arguments.get(1).getRetVal();
      }
      case("mult"):{
        return this.arguments.get(0).getRetVal() * this.arguments.get(1).getRetVal();
      }
      case("div"):{
        return this.arguments.get(0).getRetVal() / this.arguments.get(1).getRetVal();
      }
      default:{
        //should not get here
        return 0;
      }
    }
  }
}
