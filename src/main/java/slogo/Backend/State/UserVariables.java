package slogo.Backend.State;

import java.util.HashMap;
import java.util.Set;

public class UserVariables {
  private HashMap<VariableName, Double> variables;

  public UserVariables() {
    variables = new HashMap<>();
  }

  public UserVariables(HashMap<VariableName, Double> variables) {
    this.variables = variables;
  }

  public Set<VariableName> getUserVariableNames() {
    return variables.keySet();
  }

  public HashMap<VariableName, Double> getVariables() {
    return variables;
  }
}
