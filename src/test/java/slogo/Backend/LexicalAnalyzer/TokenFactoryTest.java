package slogo.Backend.LexicalAnalyzer;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import slogo.Backend.State.CommandLanguage;

class TokenFactoryTest {

  @Test
  void getRawToken() throws InvalidTokenException {
    HashMap<String[], ArrayList<RawToken>> testPairs = new HashMap<>();
    testPairs.put(
        new String[] {"fd", "50"},
        new ArrayList<RawToken>(
            List.of(new RawToken(TokenType.COMMAND, "fd"), new RawToken(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"FD", "50"},
        new ArrayList<RawToken>(
            List.of(new RawToken(TokenType.COMMAND, "FD"), new RawToken(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"FORWARD", "50"},
        new ArrayList<RawToken>(
            List.of(new RawToken(TokenType.COMMAND, "FORWARD"), new RawToken(TokenType.CONSTANT, "50"))));
    testPairs.put(
        new String[] {"BACKWARD", "90"},
        new ArrayList<RawToken>(
            List.of(
                new RawToken(TokenType.COMMAND, "BACKWARD"), new RawToken(TokenType.CONSTANT, "90"))));
    testPairs.put(
        new String[] {"fd", "50", "fd", "60", "fd", "70", "fd", "80", "fd", "90"},
        new ArrayList<RawToken>(
            List.of(
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "50"),
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "60"),
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "70"),
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "80"),
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "90"))));
    testPairs.put(
        new String[] {"FORWARD", "50", "BACKWARD", "60", "fd", "70", "LEFT", "80", "RIGHT", "90"},
        new ArrayList<RawToken>(
            List.of(
                new RawToken(TokenType.COMMAND, "FORWARD"),
                new RawToken(TokenType.CONSTANT, "50"),
                new RawToken(TokenType.COMMAND, "BACKWARD"),
                new RawToken(TokenType.CONSTANT, "60"),
                new RawToken(TokenType.COMMAND, "fd"),
                new RawToken(TokenType.CONSTANT, "70"),
                new RawToken(TokenType.COMMAND, "LEFT"),
                new RawToken(TokenType.CONSTANT, "80"),
                new RawToken(TokenType.COMMAND, "RIGHT"),
                new RawToken(TokenType.CONSTANT, "90"))));
    for (String[] stringTokensArry : testPairs.keySet()) {
      Seq<Tuple2<String, RawToken>> rawTokens =
          Seq.of(stringTokensArry).zip(testPairs.get(stringTokensArry));
      for (Tuple2<String, RawToken> tokenPair : rawTokens) {
        RawToken match = TokenFactory.getRawToken(tokenPair.v1);
        Assertions.assertNotNull(match);
        Assertions.assertInstanceOf(RawToken.class, match);
        Assertions.assertEquals(match, tokenPair.v2);
      }
    }
  }



  @ParameterizedTest
  @MethodSource("getTokenEnglishArgumentProvider")
  void getTokenEnglish(RawToken rawToken, Token token) {
    Assertions.assertEquals(TokenFactory.getToken(rawToken, CommandLanguage.ENGLISH), token);
  }

  @ParameterizedTest
  @MethodSource("getTokenSpanishArgumentProvider")
  void getTokenSpanish(RawToken rawToken, Token token) {
    Assertions.assertEquals(TokenFactory.getToken(rawToken, CommandLanguage.SPANISH), token);
  }

  static Stream<Arguments> getTokenSpanishArgumentProvider() {
    String[][] arguments = {
        {"PlUmASuBiDA","PenUp"},
        {"plUmASUbIdA","PenUp"},
        {"PLUmasuBiDa","PenUp"},
        {"PlUmASUBIDA","PenUp"},
        {"pLumasuBida","PenUp"},
        {"PLUmAsUBida","PenUp"},
        {"PLumASUBIDA","PenUp"},
        {"pLumAsUbIdA","PenUp"},
        {"DescUbrirTOrTuGa","ShowTurtle"},
        {"DeScUbrirtOrTUgA","ShowTurtle"},
        {"DEsCUBrIrTortUga","ShowTurtle"},
        {"DesCubrIrtortUga","ShowTurtle"},
        {"dEscubriRtOrtuGA","ShowTurtle"},
        {"desCUbRiRtORtuga","ShowTurtle"},
        {"deSCubrIRTORTUGA","ShowTurtle"},
        {"DescuBrIrtORtUga","ShowTurtle"},
        {"EnCUbRIrTOrtUGA","HideTurtle"},
        {"eNcubRirToRtugA","HideTurtle"},
        {"eNcUbRiRtOrTUGa","HideTurtle"},
        {"eNcUbRiRTOrtUGa","HideTurtle"},
        {"ENcUBriRtortugA","HideTurtle"},
        {"eNCUbrirtoRtuGA","HideTurtle"},
        {"ENCUBrIrtoRTUgA","HideTurtle"},
        {"encuBrIRTortUGA","HideTurtle"},
        {"CaSA","Home"},
        {"Casa","Home"},
        {"CaSA","Home"},
        {"casA","Home"},
        {"casA","Home"},
        {"CaSA","Home"},
        {"caSa","Home"},
        {"CAsA","Home"},
        {"LiMpiARpantAllA","ClearScreen"},
        {"limPiaRPaNtAlla","ClearScreen"},
        {"lIMPIArPaNtALLa","ClearScreen"},
        {"limPIaRPANtALLa","ClearScreen"},
        {"lImPiarpaNtaLLA","ClearScreen"},
        {"liMPIARpanTALLA","ClearScreen"},
        {"liMPiaRpANTAlLa","ClearScreen"},
        {"LiMpiaRpANTAllA","ClearScreen"}
    };

    return getArgumentsStream(arguments);
  }


  static Token getTokenFrom(String tokenValue){
    return new Token(TokenType.COMMAND, tokenValue);
  }

  static RawToken getRawTokenFrom(String tokenValue){
    return new RawToken(TokenType.COMMAND, tokenValue);
  }

  static Stream<Arguments> getTokenEnglishArgumentProvider() {
    String[][] arguments = {
        {"FD","Forward"},
        {"fD","Forward"},
        {"fD","Forward"},
        {"fD","Forward"},
        {"FOrwaRd","Forward"},
        {"FOrWArD","Forward"},
        {"FORwaRD","Forward"},
        {"FOrwARd","Forward"},
        {"FoRwArD","Forward"},
        {"FoRwarD","Forward"},
        {"bk","Backward"},
        {"Bk","Backward"},
        {"bK","Backward"},
        {"Bk","Backward"},
        {"BaCKwaRD","Backward"},
        {"BaCKwARD","Backward"},
        {"BacKwArD","Backward"},
        {"BacKWaRd","Backward"},
        {"BACKWaRd","Backward"},
        {"BacKwaRd","Backward"},
        {"Lt","Left"},
        {"lt","Left"},
        {"lT","Left"},
        {"Lt","Left"},
        {"LEFt","Left"},
        {"LEFt","Left"},
        {"LEFt","Left"},
        {"LEFT","Left"},
        {"LefT","Left"},
        {"LEft","Left"},
        {"Rt","Right"},
        {"RT","Right"},
        {"rT","Right"},
        {"Rt","Right"},
        {"RIGHT","Right"},
        {"RiGHT","Right"},
        {"RIghT","Right"},
        {"RIghT","Right"},
        {"RIght","Right"},
        {"RigHT","Right"},
        {"sETh","SetHeading"},
        {"SEtH","SetHeading"},
        {"sETh","SetHeading"},
        {"SetH","SetHeading"},
        {"SETHeadIng","SetHeading"},
        {"SetHeadINg","SetHeading"},
        {"SETHeadINg","SetHeading"},
        {"SeTHEaDING","SetHeading"},
        {"SetHEAding","SetHeading"},
        {"SETHEadInG","SetHeading"},
        {"TowArds","SetTowards"},
        {"tOWarDs","SetTowards"},
        {"TOWaRDs","SetTowards"},
        {"TowArdS","SetTowards"},
        {"SEtTOwaRds","SetTowards"},
        {"SetTOWaRDS","SetTowards"},
        {"SetTOWaRds","SetTowards"},
        {"SeTTowArDs","SetTowards"},
        {"SETTowardS","SetTowards"},
        {"SetTowARdS","SetTowards"},
        {"GoTo","SetPosition"},
        {"gotO","SetPosition"},
        {"gotO","SetPosition"},
        {"GOTo","SetPosition"},
        {"SETPOSition","SetPosition"},
        {"SEtPoSItiON","SetPosition"},
        {"SetPOsitiOn","SetPosition"},
        {"SEtPOsiTION","SetPosition"},
        {"SEtPoSitIOn","SetPosition"},
        {"SetPoSiTiON","SetPosition"},
        {"PeNDOwN","PenDown"},
        {"PEnDOWN","PenDown"},
        {"PeNDOwn","PenDown"},
        {"PenDoWn","PenDown"},
        {"PeNDOWn","PenDown"},
        {"PenDOWn","PenDown"},
        {"PEnUp","PenUp"},
        {"PeNUP","PenUp"},
        {"PenUp","PenUp"},
        {"PeNUp","PenUp"},
        {"PenUp","PenUp"},
        {"PeNUp","PenUp"},
        {"sT","ShowTurtle"},
        {"St","ShowTurtle"},
        {"sT","ShowTurtle"},
        {"St","ShowTurtle"},
        {"ShoWTurTLe","ShowTurtle"},
        {"ShOWTUrTLe","ShowTurtle"},
        {"SHowTURTlE","ShowTurtle"},
        {"SHOwTURTlE","ShowTurtle"},
        {"ShoWTURtLE","ShowTurtle"},
        {"ShowTURtLe","ShowTurtle"},
        {"ht","HideTurtle"},
        {"hT","HideTurtle"},
        {"hT","HideTurtle"},
        {"hT","HideTurtle"},
        {"HiDETurtLE","HideTurtle"},
        {"HiDeTurTlE","HideTurtle"},
        {"HideTurTLE","HideTurtle"},
        {"HiDeTuRTLe","HideTurtle"},
        {"HIdETUrTle","HideTurtle"},
        {"HiDeTurTle","HideTurtle"},
        {"hoMe","Home"},
        {"hoMe","Home"},
        {"HoME","Home"},
        {"home","Home"},
        {"HOME","Home"},
        {"HoME","Home"},
        {"Home","Home"},
        {"HOme","Home"},
        {"HoMe","Home"},
        {"HOme","Home"},
    };
    return getArgumentsStream(arguments);

  }

  private static Stream<Arguments> getArgumentsStream(String[][] arguments) {
    Builder<Arguments> builder = Stream.builder();

    for (String[] strings : arguments) {
      builder.add(arguments(getRawTokenFrom(strings[0]), getTokenFrom(strings[1])));
    }
    return builder.build();
  }

}