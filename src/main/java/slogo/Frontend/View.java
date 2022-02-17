package slogo.Frontend;

import javafx.stage.Stage;

public class View {
  private MainUI mainUI;

  public View(Stage primaryStage){
    mainUI = new MainUI(primaryStage);
    primaryStage.setScene(mainUI.getScene());
    primaryStage.show();
  }

}
