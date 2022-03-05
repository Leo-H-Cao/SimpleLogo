package slogo.Backend.SyntaxParser;


import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SlogoToJavaTest {

  @ParameterizedTest
  @MethodSource("testSlogoToJavaArgumentProvider")
  public void testSlogoToJava(String input, String output){
    Assertions.assertEquals(SlogoToJava.convertSlogoNameToJavaName(input),output);
  }

  public Stream<Arguments> testSlogoToJavaArgumentProvider() {
    String[][] args = {
        {"Backward", "Back"},
        {"IfElse", "Ifelse"},
        {"SetHeading", "Setheading"}
    };
    return getArgumentsStream(args);
  }

  private static Stream<Arguments> getArgumentsStream(String[][] arguments) {
    Builder<Arguments> builder = Stream.builder();

    for (String[] strings : arguments) {
      builder.add(Arguments.arguments(strings[0], (strings[1])));
    }
    return builder.build();
  }

}
