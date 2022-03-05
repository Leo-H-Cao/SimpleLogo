package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import slogo.Utilities;

/**
 * This class Tests the Instruction Splitter - taking instructions from Strings of text entered by
 * the user and converting them into whitespace delimited Strings
 * @author Alex
 */
class InstructionSplitterTest {

  @Test
  void splitInstruction() {
    Map<String, String[]> testPairs = new HashMap<>();
    testPairs.put(
        "fd 50",
        new String[]{"fd", "50"}
    );
    testPairs.put(
        "FD 50",
        new String[]{"FD", "50"}
    );
    testPairs.put(
        "FORWARD               50",
        new String[]{"FORWARD", "50"}
    );
    testPairs.put(
        "BACKWARD 90",
        new String[]{"BACKWARD", "90"}
    );
    testPairs.put(
        "fd 50 fd 60 fd 70 fd 80 fd 90",
        new String[]{"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"}
    );
    testPairs.put(
        "fd       50\n\n\n fd \t\t\t\t 60 fd       70 \n\n\tfd     \n80 fd 90\n\n",
        new String[]{"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"}
    );
    testPairs.put(
        "\t\tfd 50 fd 60 fd 70 fd 80 fd 90\t\t",
        new String[]{"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"}
    );
    testPairs.put(
        "\n\n\n\nfd 50 fd\t\t60\sfd 70 fd 80 fd 90\n\n\n\n",
        new String[]{"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"}
    );
    testPairs.put(
        "fd 50 fd\n\n60 fd\s\s70 fd\t80 fd\n90",
        new String[]{"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"}
    );
    for(String input: testPairs.keySet()){
      Deque<String> splitInstruction = InstructionSplitter.splitInstruction(input);
      Assertions.assertNotNull(splitInstruction);
      List<String> splitInstructionList = Utilities.dequeToList(splitInstruction);
      for(String s: splitInstruction){
        splitInstructionList.add(splitInstruction.pop());
      }
      Assertions.assertEquals(splitInstructionList, new ArrayList<>(List.of(testPairs.get(input))));
    }

  }

}