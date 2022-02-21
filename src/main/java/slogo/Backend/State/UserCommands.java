package slogo.Backend.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import slogo.Backend.AST;

public class UserCommands {
  private static UserCommands userCommands;
  private final Set<String> userCommandNames;
  private final HashMap<CommandName, AST> commands;
  private final ParsePreference parsePreference;

  private UserCommands() {
    userCommandNames = new HashSet<>();
    commands = new HashMap<>();
    parsePreference = UserCommands.getDefaultParsePreference();
  }

  private UserCommands(String parsePreference) {
    userCommandNames = new HashSet<>();
    commands = new HashMap<>();
    this.parsePreference = ParsePreference.valueOf(parsePreference);
  }

  public static UserCommands getUserCommands() {
    return userCommands;
  }

  public static UserCommands initializeUserCommands() {
    UserCommands.userCommands = new UserCommands();
    return getUserCommands();
  }

  public static UserCommands initializeUserCommands(String parsePreference) {
    UserCommands.userCommands = new UserCommands(parsePreference);
    return getUserCommands();
  }

  private static ParsePreference getDefaultParsePreference() {
    // TODO: load Parse Preference from persistent settings file
    return null;
  }
}
