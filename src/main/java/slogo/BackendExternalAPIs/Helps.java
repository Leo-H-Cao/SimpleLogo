package slogo.BackendExternalAPIs;

import java.util.Optional;
import slogo.Backend.HelpInformation;

/**
 * This is the interface which will be implemented by the class that provides the user with help
 * when it is requested
 */
public interface Helps {
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
