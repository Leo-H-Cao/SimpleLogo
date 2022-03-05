package slogo.Frontend;

import java.io.File;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpPage extends Application {
  public static final String HELP_DIALOG = "What do you need help with?";
  public static final String FILENAME = "";


  public HelpPage() {
    Text helpDialog = new Text(HELP_DIALOG);
    VBox helpBox = new VBox();
    helpBox.getChildren().add(helpDialog);
  }

  @Override
  public void start(Stage stage) throws Exception {}

  public void openFile() {
    File file = new File(FILENAME);
    HostServices hostServices = getHostServices();
    hostServices.showDocument(file.getAbsolutePath());
  }
}
