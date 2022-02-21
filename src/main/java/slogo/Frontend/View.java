package slogo.Frontend;

import javafx.stage.Stage;
import slogo.SLogoController;

public class View {
  public static final String TITLE = "SLogo Simulation";

  private final SLogoController myController;
  private final MainUI mainUI;

  public View(Stage primaryStage, SLogoController controller) {
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
