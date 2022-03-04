package slogo.Frontend;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class StartScreen extends Scene {

  private static final int SCREEN_SIZE = 400;
  private static final String TITLE = "SLogo";
  private static final String START_BUTTON_TEXT = "Start";
  private static final Text TITLE_TEXT = new Text(TITLE);
  private ChoiceBox selectCommandLanguage;
  private Button startButton;
  private Pane layout;


  public StartScreen(Pane startScreenLayout){
    super(startScreenLayout, SCREEN_SIZE, SCREEN_SIZE);
    this.layout = startScreenLayout;
    layout.getStyleClass().add("start-screen");
    TITLE_TEXT.getStyleClass().add("start-screen-title");
    selectCommandLanguage = new ChoiceBox<>();
    startButton = new Button(START_BUTTON_TEXT);
    displayNodes();
  }

  public Button getStartButton(){
    return startButton;
  }

  public Object getCommandLanguage(){
    System.out.println(selectCommandLanguage.getSelectionModel().getSelectedItem());
    return selectCommandLanguage.getSelectionModel().getSelectedItem();
  }

  private void displayNodes(){
    layout.getChildren().add(TITLE_TEXT);
    displayOptions();
    layout.getChildren().add(startButton);
  }

  private void displayOptions(){
    selectCommandLanguage.getItems().addAll("English", "Language 2", "Language 3");
    selectCommandLanguage.setValue("English");
    Label languageLabel = new Label("Select Command Language:");
    HBox languageSelectContainer = new HBox(5);
    languageSelectContainer.getChildren().addAll(languageLabel, selectCommandLanguage);
    layout.getChildren().add(languageSelectContainer);
  }
}
