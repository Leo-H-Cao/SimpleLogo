package slogo.Backend.LexicalAnalyzer;

import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LexResultTest {

  @ParameterizedTest
  @CsvSource(
      value = {
        "fUrNIsH STeeP aMbiTIouS EGG PUnCTUal CoNTent alIkE pErSUADe meNtiOn TAXi",
        "830.06 879.30 221.69 574.38 210.01 676.61 488.38 758.35 510.05 508.89"
      })
  void splitInstruction(String instruction) throws InvalidTokenException {
    LexResult lexResult = new LexResult(instruction);
    ArrayDeque<String> ret = lexResult.splitInstruction();
    List<String> list = List.of(instruction.split(" "));
    ArrayDeque<String> realVal = new ArrayDeque<>(list);
    for (String s : list) {
      realVal.addLast(s);
    }
    Assertions.assertEquals(ret, realVal);
  }

  @Test
  void tokenize() {}

  @Test
  void getTokens() {}
}
