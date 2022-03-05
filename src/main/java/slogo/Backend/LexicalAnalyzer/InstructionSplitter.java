package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Collection;
/**
 * This class is responsible for splitting Strings of instructions into whitespace delimited Strings
 * that can be turned into tokens.
 * @author Alex
 */
public class InstructionSplitter {

  static final String WHITESPACEREGEX = "[\\s]+"; // source: https://www.baeldung.com/java-regex-s-splus/**

  static ArrayDeque<String> splitInstruction(String instruction) {
    String[] splitArray = instruction.trim().split(InstructionSplitter.WHITESPACEREGEX);
    ArrayDeque<String> deque = new ArrayDeque<>();
    for (String s : splitArray) {
      deque.addLast(s);
    }
    return deque;
  }
}