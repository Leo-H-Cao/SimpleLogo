public interface Initializes {

  /**
   *
   * @param info
   * @return
   */
  public Boolean initalizeBackend(InitializationState info);

  /**
   * Load state from files boolean.
   *
   * @return the boolean
   */
  public Boolean loadStateFromFiles(HashMao<Class, Path>);
}