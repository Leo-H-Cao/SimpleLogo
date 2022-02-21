package slogo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.testfx.framework.junit5.ApplicationTest;

public class SLogoControllerTest extends DukeApplicationTest {
  private SLogoController slogo;
  private TextArea commandInputTextArea;

  @Override
  public void start (Stage stage) {
    slogo = new SLogoController();
    slogo.setupNewSLogo(stage);
    commandInputTextArea = lookup("#CommandInputTextArea").query();
  }

  @Test
  void doNothing() {
    assertEquals(1,1);
  }

  @Test
  void testValidCommand() {
    writeInputTo(commandInputTextArea, "fd 50");
    clickOn(lookup("#ExecuteButton").query());

  }

  @Test
  void testTextAreaClearing() {
    writeInputTo(commandInputTextArea, " \n");
    clickOn(lookup("#ExecuteButton").query());
    assertEquals(commandInputTextArea.getText().length(), 0);
  }



  @Test
  void testInvalidCommand() {
    writeInputTo(commandInputTextArea, "hi there");
    clickOn(lookup("#ExecuteButton").query());
  }




}
