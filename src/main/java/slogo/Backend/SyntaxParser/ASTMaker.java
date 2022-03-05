package slogo.Backend.SyntaxParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.SyntaxParser.Data.UserCommand;
import slogo.Backend.SyntaxParser.Data.Variable;
import slogo.Backend.SyntaxParser.ListStructure.ListEnd;
import slogo.Backend.SyntaxParser.ListStructure.ListStart;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;

/***
 * Creates an Abstract Syntax Tree consisting of a list of commands to be executed.
 * @author Jed Yang
 */

public class ASTMaker {

  private final Deque<Token> tokens;
  private final LinkedList<Operator> unevaluated = new LinkedList<>();
  private final LinkedList<Operator> evaluated = new LinkedList<>();
  private ArrayList<ArrayList<LogoList>> listsByLayer;
  private int currentLayer;
  private int currentLayerListNum;
  private LogoList root;

  private HashMap<String, Double> variableMap = new HashMap<>();

  private final Map<String, String> specialCharToClass = Map.of("[", "ListStart", "]", "ListEnd");
  private final String rootdirectory = "slogo.Backend.SyntaxParser.";


  public ASTMaker(Deque<Token> tokens) {
    this.tokens = tokens;
    listsByLayer = new ArrayList<ArrayList<LogoList>>();
    LogoList initialList = new LogoList(0);
    ArrayList<LogoList> initArrayList = new ArrayList<LogoList>();
    initArrayList.add(initialList);
    listsByLayer.add(initArrayList);
  }


  /**
   * Generate the abstract syntax tree (AST) and set a Logolist as its root
   * @return root of the AST
   */

  public LogoList parse() {
    try {
      createArgumentStacks();
    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
      System.out.println("Syntax Error");
    }
    generateAST();
    return root;
  }

  private void createArgumentStacks()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    // TODO: create operands for all tokens and place them in the correct initial stack
    int seqNum = 0;

    while (!tokens.isEmpty()) {
      Token t = tokens.getFirst();
      String tokenType = t.getType().toString();
      ResourceBundle resources = ResourceBundle.getBundle(
          rootdirectory + "CommandToClassDirectory");
      Class<?> operatorType;
      Operator nextOperator;
        // System.out.println(tokenType);

        if (!tokenType.equals("CONSTANT") && !tokenType.equals("VARIABLE")) {
          // operatorType = Class.forName("slogo.Backend.SyntaxParser." + "Command");
          if (specialCharToClass.containsKey(t.getValue())) {
            operatorType = Class.forName(
                rootdirectory + resources.getString(t.getValue()) + "." + specialCharToClass.get(
                    t.getValue()));
          } else {
            if(resources.containsKey(t.getValue())){
              String s =SlogoToJava.convertSlogoNameToJavaName(resources.getString(t.getValue()));
              String r = SlogoToJava.convertSlogoNameToJavaName(t.getValue());
              operatorType = Class.forName(
                  rootdirectory + SlogoToJava.convertSlogoNameToJavaName(resources.getString(t.getValue())) + "." + SlogoToJava.convertSlogoNameToJavaName(t.getValue()));
            }
            else if(t.getValue().equals("MakeVariable")){
              operatorType = Class.forName(
                  rootdirectory + "Data" + "." + "Make");
            }
            else{
              operatorType = Class.forName(rootdirectory + "Data.UserCommand");
            }

          }

          // operatorType = Class.forName("Command");

          Constructor<?> constructor = operatorType.getConstructor(int.class);
          nextOperator = (Operator) constructor.newInstance(seqNum);
          if(nextOperator.getClass().equals(UserCommand.class)){
            ((UserCommand) nextOperator).setName(t.getValue());
          }
        } else {
          Constructor<?> constructor;
          if(tokenType.equals("CONSTANT")){
            operatorType = Class.forName(rootdirectory + "Data.Constant");
            constructor = operatorType.getConstructor(int.class, double.class);
            nextOperator = (Operator) constructor.newInstance(seqNum,
                Double.parseDouble(t.getValue()));
          }
          else{
            operatorType = Class.forName(rootdirectory + "Data.Variable");
            constructor = operatorType.getConstructor(int.class);
            nextOperator = (Operator) constructor.newInstance(seqNum);
            ((Variable) nextOperator).setName(t.getValue());
          }



        }

        if (tokenType == "CONSTANT" || tokenType.equals("VARIABLE")) {
          evaluated.addLast(nextOperator);
        } else {
          unevaluated.addLast(nextOperator);
        }

      tokens.removeFirst();
      seqNum++;
    }
  }

  private void generateAST() {
    // TODO: use the stacks of operands to generate the AST;
    currentLayer = 0;
    currentLayerListNum = 0;
    /*
    while (!unevaluated.isEmpty()) {
      Operator nextOperator = unevaluated.getLast();

      handleOperator(nextOperator);
    }
    //root = evaluated.pop();
    if (listsByLayer.get(0).get(0).arguments.size() == 0) {
      listsByLayer.get(currentLayer).get(currentLayerListNum).addArgument(evaluated.pop());
    }
    //root = listsByLayer.get(0).get(0);

     */
    root = getList();
  }

  private LogoList getList(){
    LogoList result = new LogoList(0);
    LinkedList<Operator> locallyEvaluated = new LinkedList<>();

    while(!unevaluated.isEmpty()){
      Operator nextOperator = unevaluated.getLast();
      unevaluated.removeLast();

      if(nextOperator.getClass().equals(ListEnd.class)){
        if(unevaluated.getLast().getClass().equals(ListStart.class)){
          //this is a logical list
          locallyEvaluated.getFirst().mySeqNum = unevaluated.getLast().mySeqNum + 1;
          LogoList l = makeLogicalList(unevaluated.getLast().mySeqNum);
          locallyEvaluated.add(0, l);
        }
        else{
          locallyEvaluated.add(0,getList());
        }

        continue;
      }
      if(nextOperator.getClass().equals(ListStart.class)){
        result.setSequenceNumber(nextOperator.mySeqNum);
        return result;
      }

      //handleIntermediateOperator();
      int numArgumentsNeeded = nextOperator.getMyNumArgs();
      while(numArgumentsNeeded > 0){
        if(!locallyEvaluated.isEmpty() && locallyEvaluated.getFirst().mySeqNum <= nextOperator.mySeqNum + nextOperator.getMyNumArgs()){
          nextOperator.insertArgumentInOrder(locallyEvaluated.removeFirst());
        }
        else{
          nextOperator.addArgument(evaluated.removeLast());
        }
        numArgumentsNeeded--;
      }

      //check if previous operator has this one as an argument
      if(!unevaluated.isEmpty() && unevaluated.getLast().mySeqNum + unevaluated.getLast().getMyNumArgs() >= nextOperator.mySeqNum){
        if(!locallyEvaluated.isEmpty()){
          locallyEvaluated.getFirst().mySeqNum = nextOperator.mySeqNum + 1;
        }

        locallyEvaluated.addFirst(nextOperator);
      }
      else{
        result.addArgument(nextOperator);
      }

    }

    if(result.arguments.isEmpty()){
      result.addArgument(evaluated.get(0));
    }
    return result;
  }

  private LogoList makeLogicalList(int sequenceNumber){
    LogoList logicalList = new LogoList(sequenceNumber);
    int currentSequenceNumber = 0;
    if(!evaluated.isEmpty()){
      currentSequenceNumber = evaluated.getLast().mySeqNum;
    }
    if(currentSequenceNumber > sequenceNumber){
      currentSequenceNumber = evaluated.getLast().mySeqNum;
    }
    else{
      unevaluated.removeLast();
      return logicalList;
    }
    while(currentSequenceNumber > sequenceNumber){
      logicalList.addArgument(evaluated.removeLast());
      currentSequenceNumber--;
    }
    unevaluated.removeLast();
    return logicalList;
  }
}


