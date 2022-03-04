package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Collection;

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