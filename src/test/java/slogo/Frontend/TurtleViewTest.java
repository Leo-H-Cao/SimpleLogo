package slogo.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

class TurtleViewTest extends DukeApplicationTest {

  private View view;
  private TextArea commandInputBox;
  private Pane turtleBackground;

  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    controller.setupNewSLogo(stage);
    view = new View(stage, controller);
    clickOn(lookup("#StartButton").query());
  }

  @Test
  void testMoveTurtle() {
    Node turtleImage = lookup("#turtleImage").query();
    double Xinitial = turtleImage.getTranslateX();
    double Yinitial = turtleImage.getTranslateY();
    runCommand("Forward 50");
//    assertEquals(-50, turtleImage.getTranslateY() - Xinitial);
//    assertEquals(0, turtleImage.getTranslateX() - Yinitial);
  }

  private void runCommand(String command) {
    TextArea commandInputBox = lookup("#CommandInputTextArea").query();
    writeInputTo(commandInputBox, command);
    clickOn(lookup("#ExecuteButton").query());
  }

}
