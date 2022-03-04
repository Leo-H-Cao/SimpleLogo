package slogo.Backend;

import slogo.Backend.State.CommandLanguage;

public class Preferences {
  private CommandLanguage language;

  public Preferences(CommandLanguage language) {
    this.language = language;
  }

  public CommandLanguage getLanguage() {
    return language;
  }
}
