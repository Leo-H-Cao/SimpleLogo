package slogo.Frontend;

import javafx.stage.Stage;

public class View {
  public static final String TITLE = "SLogo Simulation";

  private MainUI mainUI;

  public View(Stage primaryStage){
    mainUI = new MainUI(primaryStage);
    primaryStage.setScene(mainUI.getScene());
    primaryStage.setTitle(TITLE);
    primaryStage.show();
  }

}
