package slogo.Frontend;

import javafx.scene.control.TextArea;
import slogo.Backend.CommandLanguage;
import slogo.Backend.History;
import slogo.FrontendExternalAPIs.CommandWindow;

public class CommandInput implements CommandWindow {
  public static final int TEXT_BOX_SIZE = 700;

  private TextArea textArea;

  public CommandInput(){
    textArea = new TextArea("Enter Commands Here");
    textArea.setMaxSize(TEXT_BOX_SIZE, TEXT_BOX_SIZE);
    textArea.getStyleClass().add("input-box");
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
}
