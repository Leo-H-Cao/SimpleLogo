package slogo.Backend;

import slogo.BackendExternalAPIs.CheckSyntax;

public class Validator implements CheckSyntax {

  /**
   * Check validity validity result.
   *
   * @param instruction the instruction
   * @return the validity result
   */
  @Override
  public ValidityResult checkValidity(String instruction) {
    return null;
  }

  /**
   * Gets error text.
   *
   * @return the error text
   */
  @Override
  public ErrorText getErrorText() {
    return null;
  }
}
