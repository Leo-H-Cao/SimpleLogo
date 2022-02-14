package slogo.BackendExternalAPIs;

import slogo.Backend.ErrorText;
import slogo.Backend.ValidityResult;

public interface CheckSyntax {
  /**
   * Check validity validity result.
   *
   * @param instruction the instruction
   * @return the validity result
   */
  ValidityResult checkValidity(String instruction);

  /**
   * Gets error text.
   *
   * @return the error text
   */
  ErrorText getErrorText();
}