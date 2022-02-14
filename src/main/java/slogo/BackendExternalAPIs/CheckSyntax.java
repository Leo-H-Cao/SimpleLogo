package slogo.BackendExternalAPIs;

public interface CheckSyntax {
  /**
   * Check validity validity result.
   *
   * @param instruction the instruction
   * @return the validity result
   */
  public ValidityResult checkValidity(String instruction);

  /**
   * Gets error text.
   *
   * @return the error text
   */
  public ErrorText getErrorText();
}