package slogo.Backend.SyntaxParser.Data;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class UserCommand extends Operator {
  private String myName;

  public UserCommand(int seqNum){
    super(seqNum);

  }
  public void setValue(int value){
    myNumArgs = 0;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    UserCommand toCommand = (UserCommand) runtimeState.getFunction(this.myName);
    return toCommand.getArguments().get(1).getRetVal(runtimeState);
  }

  public void setName(String name){
    myName = name;
  }
  public String getName(){
    return myName;
  }

}
