package slogo.Backend.State;

import java.util.HashMap;
import java.util.Set;

public class UserVariables {
  private HashMap<VariableName, Double> variables;
  private static UserVariables userVariables;

  public static UserVariables getUserVariables() {
    return userVariables;
  }

  public static UserVariables initializeUserVariablesFromData(HashMap<VariableName, Double> variables) {
    userVariables = new UserVariables(variables);
    return getUserVariables();
  }

  private UserVariables(){
    variables = new HashMap<>();
  }

  private UserVariables(HashMap<VariableName, Double> variables){
    this.variables = variables;
  }

  public Set<VariableName> getUserVariableNames(){
    return variables.keySet();
  }

  public HashMap<VariableName, Double> getVariables(){
    return variables;
  }


}
