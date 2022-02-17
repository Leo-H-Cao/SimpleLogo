package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LexResult {

  private String instruction;
  private Deque<String> splitByWhiteSpace;
  private Deque<String> scanned;
  private Deque<String> tokens;

  public LexResult(String instruction) {
    this.instruction = instruction;
    this.splitByWhiteSpace = this.splitInstruction();
    this.scanned = this.scanInstruction();
    this.tokens = this.evaluate();
  }

  protected Deque<String> evaluate() {
    return null;
  }

  protected Deque<String> scanInstruction() {
    return null;
  }

  protected Deque<String> splitInstruction()  {
    String[] s = this.instruction.split(" ");
    return new ArrayDeque<String>(List.of(s));
  }
}
