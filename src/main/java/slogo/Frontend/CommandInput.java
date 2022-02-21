package slogo.Frontend;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import slogo.Backend.State.CommandLanguage;
import slogo.Backend.State.History;
import slogo.FrontendExternalAPIs.CommandWindow;
import slogo.SLogoController;

/**
 * Test Ideas: Check if the prompt goes away when clicking Check if the text goes away when pressing
 * enter Check if the text goes away when pressing execute
 */
public class CommandInput implements CommandWindow {
  public static final int TEXT_BOX_SIZE = 700;
  public static final String PROMPT = "Enter Commands Here";

  private final SLogoController myController;
  private final TextArea textArea;
  private final Button executeButton;
  private final Pane inputBox;
  private String commandText;

  public CommandInput(SLogoController controller) {
    // TODO: add buffer so class always keeps track of what is in text box?
    // Not sure I'm understanding why we need this

    myController = controller;
    inputBox = new VBox();

    textArea = new TextArea();
    textArea.setPromptText(PROMPT);
    textArea.setMaxSize(TEXT_BOX_SIZE, TEXT_BOX_SIZE);
    textArea.getStyleClass().add("text-input");
    textArea.setId("CommandInputTextArea");
    commandText = "";

    executeButton = new Button("Execute");
    executeButton.getStyleClass().add("execute-button");
    executeButton.setId("ExecuteButton");
    addChildNodes();
    setSubmitActions();
  }

  /**
   * Returns command input from user
   *
   * @return
   */
  @Override
  public String getCommands() {
    return commandText;
  }

  /** gets command history from backend */
  @Override
  public void setCommandHistory(History history) {}

  @Override
  public void setCommandLanguage(CommandLanguage lang) {}

  public Pane getInputBox() {
    return inputBox;
  }

  private void setSubmitActions() {
    executeButton.setOnAction(
        event -> {
          submitCommand();
        });

    textArea.setOnKeyPressed(
        keyEvent -> {
          if (keyEvent.getCode() == KeyCode.ENTER) {
            submitCommand();
          }
        });
  }

  private void submitCommand() {
    commandText = textArea.getText().trim();
    if (commandText.length() == 0) return;
    textArea.clear();
    myController.handleCommandSubmitted();
  }

  private void addChildNodes() {
    inputBox.getChildren().addAll(textArea, executeButton);
  }
}
