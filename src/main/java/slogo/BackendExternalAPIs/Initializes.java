package slogo.BackendExternalAPIs;

import java.nio.file.Path;
import java.util.HashMap;
import slogo.Backend.InitializationState;
import slogo.Backend.classType;

public interface Initializes {

  /**
   *
   * @param info is the information needed to initialize the backend
   * @return Boolean which is True on initialization success and False otherwise
   */
  Boolean initalizeBackend(InitializationState info);

  /**
   * Load state from files boolean.
   *
   * @return the boolean
   */
  Boolean loadStateFromFiles(HashMap<classType, Path> state);
}