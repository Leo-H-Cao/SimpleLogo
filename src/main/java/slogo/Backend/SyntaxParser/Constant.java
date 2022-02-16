package slogo.Backend.Parser;

import java.util.ArrayList;

public class Constant extends Command{

  public Constant(int value){
    retVal = value;
    arguments = new ArrayList<>();
  }

  public double getRetVal(){
    return retVal;
  }
}
