package slogo.Frontend;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class View {
  public static final String TITLE = "SLogo Simulation";

  private MainUI mainUI;

  public View(Stage primaryStage, EventHandler<? super KeyEvent> eventHandler){
    mainUI = new MainUI(primaryStage);
    mainUI.getScene().setOnKeyPressed(eventHandler);
    primaryStage.setScene(mainUI.getScene());
    primaryStage.setTitle(TITLE);
    primaryStage.show();
  }

}
