package slogo.Frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import slogo.Backend.State.CommandLanguage;

public class StartScreen extends Scene {

  private static final int SCREEN_SIZE = 400;
  private static final String TITLE = "SLogo";
  private static final String START_BUTTON_TEXT = "Start";
  private Text titleText;
  private ChoiceBox selectCommandLanguage;
  private Button startButton;
  private VBox layout;


  /**
   * Starting splash screen for user to choose command language
   * @author Leo Cao
   */
  public StartScreen(Pane startScreenLayout){
    super(startScreenLayout, SCREEN_SIZE, SCREEN_SIZE);
    layout = (VBox) startScreenLayout;
    layout.setAlignment(Pos.TOP_CENTER);
    layout.getStyleClass().add("start-screen");
    titleText = new Text(TITLE);
    selectCommandLanguage = new ChoiceBox<>();
    startButton = new Button(START_BUTTON_TEXT);
    startButton.setId("StartButton");
    displayNodes();
  }

  public Button getStartButton(){
    return startButton;
  }

  public CommandLanguage getCommandLanguage(){
    return (CommandLanguage) selectCommandLanguage.getSelectionModel().getSelectedItem();
  }

  private void displayNodes(){
    displayTitle();
    displayOptions();
    startButton.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
    layout.getChildren().add(startButton);
  }

  private void displayTitle(){
    titleText.getStyleClass().add("start-screen-title");
    titleText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
    layout.getChildren().add(titleText);
  }

  private void displayOptions(){
    selectCommandLanguage.getItems().addAll(CommandLanguage.values());
    selectCommandLanguage.setValue(CommandLanguage.ENGLISH);
    Label languageLabel = new Label("Select Command Language:");
    languageLabel.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
    HBox languageSelectContainer = new HBox(5);
    languageSelectContainer.setAlignment(Pos.CENTER);
    languageSelectContainer.getChildren().addAll(languageLabel, selectCommandLanguage);
    layout.getChildren().add(languageSelectContainer);
  }

}
