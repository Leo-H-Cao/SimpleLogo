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
        arguments(new RawToken(TokenType.COMMAND, "fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "forward"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FORWARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "forwARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "forwARD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "foRWard"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "fD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "Fd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FoRwARd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FoRWarD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "ForWard"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FORWarD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FOrwArD"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "FoRwARd"), new Token(TokenType.COMMAND, "Forward")),
        arguments(new RawToken(TokenType.COMMAND, "BK"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "bk"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BAckWArd"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BacKWard"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BACkWArD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BackWARD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BACKwArD"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "BacKWArd"), new Token(TokenType.COMMAND, "Backward")),
        arguments(new RawToken(TokenType.COMMAND, "lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "Lt"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "LEFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "LEfT"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "LEFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "LeFT"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "LEFt"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "Left"), new Token(TokenType.COMMAND, "Left")),
        arguments(new RawToken(TokenType.COMMAND, "rt"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "rt"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "rT"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RT"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RigHt"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RiGHT"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RIGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "RiGht"), new Token(TokenType.COMMAND, "Right")),
        arguments(new RawToken(TokenType.COMMAND, "sETH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "seTH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "sEtH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "sEtH"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SeTHeading"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SetHEaDing"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SeTHEADInG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SeTHeAdiNG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SEtHEAdiNG"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "SEtHEading"), new Token(TokenType.COMMAND, "SetHeading")),
        arguments(new RawToken(TokenType.COMMAND, "TOwArds"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "towARDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "TOwarDs"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "towardS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SEtTOwARDs"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SETTOWARDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SeTTOwaRDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SETTOWArDS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SETToWARdS"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "SeTTowARds"), new Token(TokenType.COMMAND, "SetTowards")),
        arguments(new RawToken(TokenType.COMMAND, "GoTO"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "GOTo"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "GOTO"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "GOTo"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SeTPosiTiON"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SETPOSiTIOn"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SetPoSItion"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SETPoSItIon"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SETPosiTION"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "SEtPOSITIOn"), new Token(TokenType.COMMAND, "SetPosition")),
        arguments(new RawToken(TokenType.COMMAND, "pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "pU"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "pu"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PEnDOWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PEnDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PenDOwN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PEnDOWn"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PENDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "PeNDoWN"), new Token(TokenType.COMMAND, "PenDown")),
        arguments(new RawToken(TokenType.COMMAND, "Pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "Pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "pd"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "pD"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PENUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PenUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PenUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PENUp"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PeNUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "PEnUP"), new Token(TokenType.COMMAND, "PenUp")),
        arguments(new RawToken(TokenType.COMMAND, "st"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "st"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "ST"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "ST"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "SHowTuRtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "ShoWTurtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "SHOWTUrTLE"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "SHowTUrtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "SHowTurtle"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "ShowTURtlE"), new Token(TokenType.COMMAND, "ShowTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "ht"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HT"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HIdETuRTLe"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HiDeTurTLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HIDETUrTLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HiDeTurtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HideTurtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "HidETURtLE"), new Token(TokenType.COMMAND, "HideTurtle")),
        arguments(new RawToken(TokenType.COMMAND, "homE"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HOME"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HOME"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "hOme"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HoMe"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HomE"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HOmE"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HomE"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HOme"), new Token(TokenType.COMMAND, "Home")),
        arguments(new RawToken(TokenType.COMMAND, "HOme"), new Token(TokenType.COMMAND, "Home")));
  }
}
