package slogo.Frontend;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UserVariablesContainer extends ViewUserDefined{

  public static final String VARIABLES_CONTAINER_TITLE = "User-Defined Variables";

  private Pane variablesContainer;
  private Text variablesTitle;

  public UserVariablesContainer(){
    variablesContainer = new VBox();
    variablesTitle = new Text(VARIABLES_CONTAINER_TITLE);
    variablesContainer.getChildren().add(variablesTitle);
  }

  public Pane getUserVariablesContainer() {
    return variablesContainer;
  }
}
