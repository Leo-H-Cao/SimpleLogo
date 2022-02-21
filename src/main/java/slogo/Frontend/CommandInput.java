package slogo.Frontend;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import slogo.Backend.CommandLanguage;
import slogo.Backend.History;
import slogo.FrontendExternalAPIs.CommandWindow;

/**
 * Test Ideas:
 * Check if the prompt goes away when clicking
 * Check if the text goes away when pressing enter
 * Check if the text goes away when pressing execute
 *
 */

public class CommandInput implements CommandWindow {
  public static final int TEXT_BOX_SIZE = 700;
  public static final String PROMPT = "Enter Commands Here";

  private TextArea textArea;
  private Button executeButton;
  private Pane inputBox;

  public CommandInput(){
    //TODO: add buffer so class always keeps track of what is in text box?
    // Not sure I'm understanding why we need this

    inputBox = new VBox();

    textArea = new TextArea();
    textArea.setPromptText(PROMPT);
    textArea.setMaxSize(TEXT_BOX_SIZE, TEXT_BOX_SIZE);
    textArea.getStyleClass().add("text-input");

    executeButton = new Button("Execute");
    executeButton.getStyleClass().add("execute-button");
    addChildNodes();
    setSubmitActions();
  }

  /**
   * Returns command input from user
   * @return
   */
  @Override
  public String getCommandInput(){
    String commands = textArea.getText().trim();
    textArea.clear();
    return commands;
  }

  /**
   * gets command history from backend
   */
  @Override
  public void setCommandHistory(History history){

  }

  @Override
  public void setCommandLanguage(CommandLanguage lang){
  }

  public Pane getInputBox(){
    return inputBox;
  }

  private void setSubmitActions(){
    executeButton.setOnAction(event -> {
      getCommandInput();
    });

    textArea.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER)  {
        getCommandInput();
      }
    });
  }

  private void addChildNodes(){
    inputBox.getChildren().addAll(textArea, executeButton);
  }
}
