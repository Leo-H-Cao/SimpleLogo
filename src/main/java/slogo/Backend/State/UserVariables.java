package slogo.Backend.State;

import java.util.HashMap;
import java.util.Set;

public class UserVariables {
  private static UserVariables userVariables;
  private final HashMap<VariableName, Double> variables;

  private UserVariables() {
    variables = new HashMap<>();
  }

  private UserVariables(HashMap<VariableName, Double> variables) {
    this.variables = variables;
  }

  public static UserVariables getUserVariables() {
    return userVariables;
  }

  public static UserVariables initializeUserVariablesFromData(
      HashMap<VariableName, Double> variables) {
    userVariables = new UserVariables(variables);
    return getUserVariables();
  }

  public Set<VariableName> getUserVariableNames() {
    return variables.keySet();
  }

  public HashMap<VariableName, Double> getVariables() {
    return variables;
  }
}
