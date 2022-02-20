package slogo.Frontend;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
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

  public CommandInput(){
    //TODO: add buffer so class always keeps track of what is in text box?
    // Not sure I'm understanding why we need this
    textArea = new TextArea();
    textArea.setPromptText(PROMPT);
    textArea.setMaxSize(TEXT_BOX_SIZE, TEXT_BOX_SIZE);
    textArea.getStyleClass().add("input-box");
    executeButton = new Button("Execute");
    executeButton.getStyleClass().add("execute-button");
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

  public TextArea getTextArea() {
    return textArea;
  }

  public Button getExecuteButton(){
    return executeButton;
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
}
