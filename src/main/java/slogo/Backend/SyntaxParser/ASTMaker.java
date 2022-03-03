package slogo.Backend.SyntaxParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import slogo.Backend.LexicalAnalyzer.Token;
import slogo.Backend.SyntaxParser.ListStructure.ListEnd;
import slogo.Backend.SyntaxParser.ListStructure.ListStart;
import slogo.Backend.SyntaxParser.ListStructure.LogoList;

public class ASTMaker {
  private final ArrayDeque<Token> tokens;
  private final LinkedList<Operator> unevaluated = new LinkedList<>();
  private final LinkedList<Operator> evaluated = new LinkedList<>();
  private ArrayList<ArrayList<LogoList>> listsByLayer;
  private int currentLayer;
  private int currentLayerListNum;
  private LogoList root;

  private HashMap<String, Double> variableMap = new HashMap<>();

  private final Map<String, String> specialCharToClass = Map.of("[", "ListStart", "]", "ListEnd");
  private final String rootdirectory = "slogo.Backend.SyntaxParser.";


  public ASTMaker(ArrayDeque<Token> tokens) {
    this.tokens = tokens;
    listsByLayer = new ArrayList<ArrayList<LogoList>>();
    LogoList initialList = new LogoList(0);
    ArrayList<LogoList> initArrayList = new ArrayList<LogoList>();
    initArrayList.add(initialList);
    listsByLayer.add(initArrayList);
  }

  public LogoList parse() {
    createArgumentStacks();
    generateAST();
    return root;
  }

  private void createArgumentStacks() {
    // TODO: create operands for all tokens and place them in the correct initial stack
    int seqNum = 0;

    while (!tokens.isEmpty()) {
      Token t = tokens.getFirst();
      String tokenType = t.getTyoe().toString();
      ResourceBundle resources = ResourceBundle.getBundle(rootdirectory + "CommandToClassDirectory");

      try {
        // System.out.println(tokenType);
        Class<?> operatorType;
        Operator nextOperator;
        if (!tokenType.equals("CONSTANT") && !tokenType.equals("VARIABLE")) {
          // operatorType = Class.forName("slogo.Backend.SyntaxParser." + "Command");
          if(specialCharToClass.containsKey(t.getValue())){
            operatorType = Class.forName(rootdirectory + resources.getString(t.getValue()) + "."  + specialCharToClass.get(t.getValue()));
          }
          else{
            operatorType = Class.forName(rootdirectory + resources.getString(t.getValue()) + "."  + t.getValue());
          }

          // operatorType = Class.forName("Command");
          Constructor<?> constructor = operatorType.getConstructor(int.class);
          nextOperator = (Operator) constructor.newInstance(seqNum);
        } else {
          operatorType = Class.forName(rootdirectory + "Data.Constant");
          Constructor<?> constructor = operatorType.getConstructor(int.class, double.class);
          nextOperator = (Operator) constructor.newInstance(seqNum, Double.parseDouble(t.getValue()));
        }

        if (tokenType == "CONSTANT" || tokenType.equals("Variable")) {
          evaluated.addLast(nextOperator);
        } else {
          unevaluated.addLast(nextOperator);
        }
      } catch (ClassNotFoundException e) {
        // TODO: REPLACE THIS LATER
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      tokens.removeFirst();
      seqNum++;
    }
  }

  private void generateAST() {
    // TODO: use the stacks of operands to generate the AST;
    currentLayer = 0;
    currentLayerListNum = 0;
    while (!unevaluated.isEmpty()) {
      Operator nextOperator = unevaluated.getLast();

      handleOperator(nextOperator);
    }
    //root = evaluated.pop();
    if(listsByLayer.get(0).get(0).arguments.size()==0){
      listsByLayer.get(currentLayer).get(currentLayerListNum).addArgument(evaluated.pop());
    }
    root = listsByLayer.get(0).get(0);
  }

  private void handleOperator(Operator operator) {
    if(operator.getClass().equals(ListEnd.class)){
      unevaluated.removeLast();
      currentLayer++;
      LogoList newLogoList = new LogoList(0);
      ArrayList<LogoList> newLayer = new ArrayList<LogoList>();
      newLayer.add(newLogoList);
      listsByLayer.add(newLayer);
      return;
    }
    if(operator.getClass().equals(ListStart.class)){
      unevaluated.removeLast();

      if(unevaluated.getLast().equals(ListEnd.class)){
        //there are more lists to parse
        listsByLayer.get(currentLayer).add(0, new LogoList(0));
        currentLayerListNum++;
      }
      else{
        //no more lists in this layer
        listsByLayer.get(currentLayer).get(0).setSequenceNumber(operator.mySeqNum);
        for(int i=listsByLayer.get(currentLayer).size()-1; i>=0; i--){
          evaluated.add(listsByLayer.get(currentLayer).get(i));
        }
        //evaluated.addAll(listsByLayer.get(currentLayer));
        listsByLayer.remove(currentLayer);
        currentLayer--;

      }

      return;
    }
    int numOperands = operator.getMyNumArgs();
    while (numOperands > 0) {
      if(currentLayer != 0 && !listsByLayer.get(currentLayer).get(currentLayerListNum).getArguments().isEmpty() && operator.mySeqNum + operator.getMyNumArgs() >= listsByLayer.get(currentLayer).get(currentLayerListNum).getArguments().get(0).mySeqNum){
        operator.addArgument(listsByLayer.get(currentLayer).get(currentLayerListNum).getArguments().get(0));
        listsByLayer.get(currentLayer).get(currentLayerListNum).getArguments().remove(0);
        numOperands--;
        continue;
      }
      int i = evaluated.size()-1;
      while(!evaluated.isEmpty()){
        if(evaluated.get(i).mySeqNum <= operator.mySeqNum + operator.getMyNumArgs()){
          operator.addArgument(evaluated.get(i));
          evaluated.remove(i);
          break;
        }
        i--;
      }

      numOperands--;
    }
    if(unevaluated.size()==1){
      if(currentLayer == 0){
        evaluated.addLast(operator);
        listsByLayer.get(currentLayer).get(currentLayerListNum).addArgument(operator);
        unevaluated.removeLast();
        return;
      }

    }
    unevaluated.removeLast();

    if((unevaluated.getLast().getMyNumArgs() + unevaluated.getLast().mySeqNum < operator.mySeqNum) && !unevaluated.getLast().getClass().equals(ListStart.class)){
      //the next operator does not use the current operator as an operand. Insert this operator in the list

      listsByLayer.get(currentLayer).get(currentLayerListNum).addArgument(operator);
    }
    else if (currentLayer==0){
      if(!evaluated.isEmpty()){
        evaluated.getLast().setSequenceNumber(operator.mySeqNum + 1);
      }
      evaluated.addFirst(operator);
    }
    else{
      if(!listsByLayer.get(currentLayer).get(currentLayerListNum).arguments.isEmpty()){
        listsByLayer.get(currentLayer).get(currentLayerListNum).arguments.get(0).setSequenceNumber(operator.mySeqNum + 1);
      }
      listsByLayer.get(currentLayer).get(currentLayerListNum).addArgument(operator);
    }

  }
}
