package slogo.Backend.SyntaxParser;

import java.util.ArrayList;

public class Constant extends Operator {

  public Constant(int value){
    retVal = value;
    arguments = new ArrayList<>();
  }

  public double getRetVal(){
    return retVal;
  }
}
