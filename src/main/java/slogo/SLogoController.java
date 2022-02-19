package slogo;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import slogo.Backend.InitializationState;
import slogo.Backend.ModelState;
import slogo.Frontend.MainUI;

public class SLogoController {
  public static final String SLOGO_PROGRAM_TITLE = "SLogo";
  private ModelState model;
  private Stage myStage;

  public SLogoController(Stage stage) {
    model = new ModelState();
    myStage = stage;



  }

  public void setupNewSlogo() {
    // Set up and show stage
    MainUI gui = new MainUI(myStage);
    Scene mainScene = gui.getScene();
    mainScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
    myStage.setScene(mainScene);
    myStage.setTitle(SLOGO_PROGRAM_TITLE);
    myStage.show();

    // initialize window to set parameters
    // frontend stuff to get language + other initial parameters that the backend needs to know
    // resource file will have defaults
    // UI should allow user to change those attributes before starting up the model
    InitializationState initializationState = new InitializationState();
    model.initalizeBackend(initializationState);
  }

  public void setupSlogoFromFile() {
    //mutates backend
    //model.loadStateFromFiles();
  }

  private void handleKeyInput(KeyCode code) {

  }

}
