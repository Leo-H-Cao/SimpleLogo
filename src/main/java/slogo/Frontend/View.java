package slogo.Frontend;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.Backend.State.CommandLanguage;
import slogo.SLogoController;

public class View {
  public static final String TITLE = "SLogo Simulation";

  public static Stage stage;
  private final SLogoController myController;
  private final MainUI mainUI;
  private Pane startScreenLayout;


  public View(Stage primaryStage, SLogoController controller) {
    stage = primaryStage;
    myController = controller;
    mainUI = new MainUI(primaryStage, controller);
    startScreenLayout = new VBox(50);
    displayStartScreen();
  }

  private void displayStartScreen(){
    StartScreen startScreen = new StartScreen(startScreenLayout);
    startScreen.getStartButton().setOnAction(e -> {
        handleStartClick(startScreen.getCommandLanguage());
    });
    stage.setScene(startScreen);
    stage.show();
  }

  private void handleStartClick(CommandLanguage language){
    mainUI.getScene().setOnKeyPressed(e -> myController.handleKeyInput(e.getCode()));
    stage.setScene(mainUI.getScene());
    stage.setTitle(TITLE);
    stage.show();
    myController.initializeBackend(language);
  }

  public MainUI getMainUI() {
    return mainUI;
  }
}
