package slogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.Backend.State.ModelState;

public class SLogoControllerTest extends DukeApplicationTest {
  private SLogoController slogo;
  private TextArea commandInputTextArea;

  @Override
  public void start(Stage stage) {
    slogo = new SLogoController();
    slogo.setupNewSLogo(stage);
    commandInputTextArea = lookup("#CommandInputTextArea").query();
  }

  @Test
  void doNothing() {
    assertEquals(1, 1);
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

  @Test
  void testInvalidBackendInitialization() {
    ModelState model = new ModelState();
    InitializationState initializationState = new InitializationState();
//    assertNull(model.initalizeBackend(initializationState));
    assertNull(model.getUserVariables());
    assertThrows(NullPointerException.class, () -> model.setCommandLanguage("not a language"));
  }
}
