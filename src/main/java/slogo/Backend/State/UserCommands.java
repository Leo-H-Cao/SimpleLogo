package slogo.Backend.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import slogo.Backend.AST;

public class UserCommands {
  private Set<String> userCommandNames;
  private HashMap<CommandName, AST> commands;
  private ParsePreference parsePreference;

  public UserCommands() {
    userCommandNames = new HashSet<>();
    commands = new HashMap<>();
    parsePreference = UserCommands.getDefaultParsePreference();
    //replace null with enum
    if(parsePreference.equals(null)){
      this.loadUserCommands();
    }
  }

  private UserCommands(String parsePreference) {
    userCommandNames = new HashSet<>();
    commands = new HashMap<>();
    this.parsePreference = ParsePreference.valueOf(parsePreference);
  }

  public void loadUserCommands(){
    //TODO: Load User Commands into AST eagerly (all at once)
    return;
  }

  private static ParsePreference getDefaultParsePreference() {
    // TODO: load Parse Preference from persistent settings file
    return null;
  }
}
