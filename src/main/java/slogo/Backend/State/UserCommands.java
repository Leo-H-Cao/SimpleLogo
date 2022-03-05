package slogo.Backend.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UserCommands {
  private Set<String> userCommandNames;
//  private HashMap<CommandName, AST> commands;

//  public UserCommands() {
//    userCommandNames = new HashSet<>();
////    commands = new HashMap<>();
//    //replace null with enum
//    }
//  }

  private UserCommands(String parsePreference) {
    userCommandNames = new HashSet<>();
//    commands = new HashMap<>();
  }

  public void loadUserCommands(){
    //TODO: Load User Commands into AST eagerly (all at once)
    return;
  }

}
