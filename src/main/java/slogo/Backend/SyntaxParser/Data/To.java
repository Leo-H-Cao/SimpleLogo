package slogo.Backend.SyntaxParser.Data;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.SyntaxParser.LogoRuntimeState;
import slogo.Backend.SyntaxParser.Operator;

public class To extends Operator {

  public To(int seqNum){
    super(seqNum);
    myNumArgs = 3;
  }

  public double getRetVal(LogoRuntimeState runtimeState)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    UserCommand command = (UserCommand) arguments.get(0);
    command.addArgument(arguments.get(2));
    command.addArgument(arguments.get(1));
    runtimeState.addFunction(command.getName(),command);
    return 0;
  }

}