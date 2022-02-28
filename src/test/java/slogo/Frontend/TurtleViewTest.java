package slogo.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.text.html.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

class TurtleViewTest extends DukeApplicationTest {

  private View view;
  private Node turtleImage;
  private TextArea commandInputBox;
  private Pane turtleBackground;

  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    turtleImage = lookup("#turtleImage").query();
    commandInputBox = lookup("#CommandInputTextArea").query();
  }
  @Test
  void testMoveTurtle() {
    double Xinitial = turtleImage.getTranslateX();
    double Yinitial = turtleImage.getTranslateY();
//    runCommand("Forward 50");
//    assertEquals(-50, turtleImage.getTranslateY() - Xinitial);
//    assertEquals(0, turtleImage.getTranslateX() - Yinitial);
  }

  private void runCommand(String command) {
    writeInputTo(commandInputBox, command);
    clickOn(lookup("#ExecuteButton").query());
  }

}
