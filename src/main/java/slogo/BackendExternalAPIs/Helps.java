package slogo.BackendExternalAPIs;

import java.util.Optional;
import slogo.Backend.HelpInformation;

public interface Help {
  /**
   * This method is called when the user requests help.
   *
   * @param token the token which the user requested specific help for, if applicable. If this
   * value is Null, then general help is returned.
   * @return help information in the form of a HelpInformation object, which can either contain
   * specific or general help.
   */
  HelpInformation getHelp(Optional<String> token);
}
