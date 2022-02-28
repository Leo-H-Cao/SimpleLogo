package slogo.Frontend.ToolBarButtons;

import javafx.scene.control.ChoiceBox;

public class LanguageSelect {

  private ChoiceBox languageChoiceBox;

  public LanguageSelect(String label) {
    languageChoiceBox = new ChoiceBox();
    languageChoiceBox.setValue(label);
    languageChoiceBox.getItems().addAll("English", "Language 2", "Language 3");
  }

  public ChoiceBox getChoiceBox() {
    return languageChoiceBox;
  }
}
