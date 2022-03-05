package slogo.Frontend;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LeftBorderContainer extends ViewUserDefined{

  private static final String USER_VARIABLES_TITLE = "User-Defined Variables";
  private static final String COMMAND_OUTPUT_TITLE = "Command Output";

  private Pane leftBorderContainer;
  private Text variablesTitle;
  private CommandOutput myCommandOutput;
  private Region outputPadding;
  private Text commandOutputTitle;

  /**
   * Container for left border of border pane, includes user defined variables and command output
   */
  public LeftBorderContainer(){
    leftBorderContainer = new VBox();
    variablesTitle = new Text(USER_VARIABLES_TITLE);
    commandOutputTitle = new Text(COMMAND_OUTPUT_TITLE);
    myCommandOutput = new CommandOutput();
    outputPadding = new Region();
    outputPadding.getStyleClass().add("output-padding-region");
    leftBorderContainer.getChildren().addAll(variablesTitle, outputPadding, commandOutputTitle, myCommandOutput.getTextArea());
  }

  public Pane getLeftBorderContainer() {
    return leftBorderContainer;
  }

  public CommandOutput getCommandOutput(){
    return myCommandOutput;
  }
}
