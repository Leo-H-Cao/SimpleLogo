package slogo.Backend.SyntaxParser.ListStructure;

import java.util.ArrayList;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class ListEnd extends Operator {
  public ListEnd(int seqNum){
    super(seqNum);
    this.arguments = new ArrayList<>();
  }

  public double getRetVal(LogoRuntimeState runtimeState){
    return 0;
  }

}
