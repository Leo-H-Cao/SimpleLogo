package slogo.FrontendInternalAPIs;

import javafx.scene.layout.Pane;

public interface ControlView {

  /**
   * Called when initializing root Pane object for display
   */
  public void createRoot();

  /**
   * to add any pages to the scene
   */
  public void addToRoot();

  /**
   * remove any pages from the scene
   */
  public void removeFromRoot();

  /**
   * creates a popup window
   */
  public void showPopupWindow();

}
