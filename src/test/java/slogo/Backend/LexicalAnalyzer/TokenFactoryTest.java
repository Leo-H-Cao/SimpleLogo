package slogo.Backend.LexicalAnalyzer;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
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
        Assertions.assertInstanceOf(Token.class, match);
        Assertions.assertEquals(match, tokenPair.v2);
      }
    }
  }

  @ParameterizedTest
  @MethodSource("getTokenEnglishArgumentProvider")
  void getTokenEnglish(RawToken rawToken, Token token) {
    Assertions.assertEquals(TokenFactory.getToken(rawToken, CommandLanguage.ENGLISH), token);
  }

  static Token getTokenFrom(String tokenValue){
    return new Token(TokenType.COMMAND, tokenValue);
  }

  static RawToken getRawTokenFrom(String tokenValue){
    return new RawToken(TokenType.COMMAND, tokenValue);
  }

  static Stream<Arguments> getTokenEnglishArgumentProvider() {
    return Stream.of(

        arguments(getRawTokenFrom("fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("forward"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FORWARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("forwARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("forwARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("foRWard"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("fD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("Fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FoRwARd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FoRWarD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("ForWard"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FORWarD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FOrwArD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("FoRwARd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(getRawTokenFrom("BK"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BAckWArd"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BacKWard"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BACkWArD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BackWARD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BACKwArD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("BacKWArd"), new Token(TokenType.COMMAND, "Backward")),
        arguments(getRawTokenFrom("lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("Lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("LEFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("LEfT"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("LEFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("LeFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("LEFt"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("Left"), new Token(TokenType.COMMAND, "Left")),
        arguments(getRawTokenFrom("rt"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("rt"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("rT"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RT"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RigHt"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RiGHT"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RIGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(getRawTokenFrom("sETH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("seTH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("sEtH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("sEtH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SeTHeading"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SetHEaDing"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SeTHEADInG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SeTHeAdiNG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SEtHEAdiNG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("SEtHEading"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(getRawTokenFrom("TOwArds"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("towARDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("TOwarDs"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("towardS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SEtTOwARDs"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SETTOWARDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SeTTOwaRDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SETTOWArDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SETToWARdS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("SeTTowARds"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(getRawTokenFrom("GoTO"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("GOTo"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("GOTO"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("GOTo"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SeTPosiTiON"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SETPOSiTIOn"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SetPoSItion"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SETPoSItIon"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SETPosiTION"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("SEtPOSITIOn"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(getRawTokenFrom("pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("pU"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PEnDOWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PEnDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PenDOwN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PEnDOWn"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PENDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("PeNDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(getRawTokenFrom("Pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("Pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("pD"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PENUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PenUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PenUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PENUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PeNUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("PEnUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(getRawTokenFrom("st"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("st"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("ST"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("ST"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("SHowTuRtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("ShoWTurtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("SHOWTUrTLE"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("SHowTUrtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("SHowTurtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("ShowTURtlE"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(getRawTokenFrom("HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("ht"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HIdETuRTLe"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HiDeTurTLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HIDETUrTLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HiDeTurtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HideTurtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("HidETURtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(getRawTokenFrom("homE"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HOME"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HOME"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("hOme"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HoMe"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HomE"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HOmE"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HomE"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HOme"), new Token(TokenType.COMMAND, "Home")),
        arguments(getRawTokenFrom("HOme"), new Token(TokenType.COMMAND, "Home")));
  }
}
