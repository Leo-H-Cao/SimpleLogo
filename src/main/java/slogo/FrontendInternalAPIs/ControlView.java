package slogo.FrontendInternalAPIs;

import javafx.scene.Node;

public interface ControlView {

  /** Called when initializing root Pane object for display */
  void createRoot();

  /** to add any pages to the scene */
  void addToRoot(Node node);

  /** remove any pages from the scene */
  void removeFromRoot(Node node);

  /** creates a popup window */
  void showPopupWindow();
}
