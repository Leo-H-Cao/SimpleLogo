package slogo.Backend.SyntaxParser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.TurtleState.Turtle;

public class InstructionRunner {
//  History myTurtleHistory;

  public InstructionRunner(Turtle initialTurtleState){
//    myTurtleHistory = new History();
  }

  public Turtle runInstruction(ArrayDeque<Token> tokens)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ASTMaker myMaker = new ASTMaker(tokens);
    Operator root = myMaker.parse();
    ArrayDeque<Turtle> turtleStack = new ArrayDeque<>();
//    turtleStack.add(myTurtleHistory.getTurtleHistory().getLast().getLast());
    root.getRetVal();
    return turtleStack.getLast();
  }

}
