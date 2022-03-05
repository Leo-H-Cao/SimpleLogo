package slogo.BackendExternalAPIs;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashMap;
import slogo.Backend.FileReadingException;
import slogo.Backend.Preferences;
import slogo.Backend.State.ModelState;
import slogo.Backend.className;

/**
 * This class ____
 * @author Alex
 */
public interface Initialiazable {

  /**
   * @param overrides has whatever Preferences for which the user wants to override defaults
   * @return ModelState initialized by backend
   */
  ModelState initalizeBackend(Preferences overrides);

  /**
   * This method initializes the backend by telling the model to load files containing a previous
   * state of the backend. It throws a FileNotFoundException if any of the Path objects given do not
   * lead to files.
   *
   * @param state the state
   * @return ModelState object which was initialized by the backend
   * @throws FileNotFoundException is thrown when a file is not found at any of the given Path
   *     objects
   * @throws FileReadingException the file reading exception is throw when the file Path objects
   * point to files that exist, but the backend is unable to read them
   */
  ModelState loadBackendStateFromFiles(HashMap<className, Path> state)
      throws FileNotFoundException, FileReadingException;
}
