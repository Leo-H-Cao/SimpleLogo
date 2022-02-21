package slogo.Frontend;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import slogo.SLogoController;

public class View {
  public static final String TITLE = "SLogo Simulation";

  private SLogoController myController;
  private MainUI mainUI;


  public View(Stage primaryStage, SLogoController controller){
    myController = controller;
    mainUI = new MainUI(primaryStage, controller);
    mainUI.getScene().setOnKeyPressed(e -> controller.handleKeyInput(e.getCode()));
    primaryStage.setScene(mainUI.getScene());
    primaryStage.setTitle(TITLE);
    primaryStage.show();
  }

  public MainUI getMainUI() {
    return mainUI;
  }

}
