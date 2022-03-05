package slogo.Backend.SyntaxParser;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlogoToJavaTest {

  @Test
  public void testSlogoToJava(String input, String output){
    Assertions.assertEquals(SlogoToJava.convertSlogoNameToJavaName("Backward"),"Back");
    Assertions.assertEquals(SlogoToJava.convertSlogoNameToJavaName("IfElse"),"Ifelse");
    Assertions.assertEquals(SlogoToJava.convertSlogoNameToJavaName("SetHeading"),"Setheading");
  }
//
//  @Deprecated
//  public Stream<Arguments> testSlogoToJavaArgumentProvider() {
//    String[][] args = {
//        {"Backward", "Back"},
//        {"IfElse", "Ifelse"},
//        {"SetHeading", "Setheading"}
//    };
//    return getArgumentsStream(args);
//  }
//
//  @Deprecated
//  private static Stream<Arguments> getArgumentsStream(String[][] arguments) {
//    Builder<Arguments> builder = Stream.builder();
//
//    for (String[] strings : arguments) {
//      builder.add(Arguments.arguments(strings[0], strings[1]));
//    }
//    return builder.build();
//  }

}
