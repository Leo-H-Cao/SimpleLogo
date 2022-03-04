package slogo.Backend;


public class Utilities {
  public static String getTitleCaseOf(String str) {
    String firstLetter = str.substring(0,1);
    String rest = str.substring(1);
    return firstLetter.toUpperCase() + rest.toLowerCase();
  }

}
