package slogo.Backend;

import java.lang.reflect.InvocationTargetException;
import slogo.Backend.LexicalAnalyzer.InvalidTokenException;
import slogo.Backend.LexicalAnalyzer.LexResult;
import slogo.Backend.State.TurtleHistory;
import slogo.Backend.SyntaxParser.ASTMaker;
import slogo.Backend.SyntaxParser.Operator;
import slogo.BackendExternalAPIs.ControlsTurtle;

@Deprecated
public class TurtleController implements ControlsTurtle {
  TurtleHistory myHistory;

  public TurtleController() {
    myHistory = new TurtleHistory();
  }


}
