package slogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.Backend.InvalidCommandLanguageException;
import slogo.Backend.Preferences;
import slogo.Backend.State.CommandLanguage;
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
    writeInputTo(commandInputTextArea, "Forward 50");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testForwardExecution() {
    writeInputTo(commandInputTextArea, "Forward 100");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testBackExecution() {
    writeInputTo(commandInputTextArea, "Back 100");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testLeftExecution() {
    writeInputTo(commandInputTextArea, "Left 1.5");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testRightExecution() {
    writeInputTo(commandInputTextArea, "Right 1.5");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testSetHeadingExecution() {
    writeInputTo(commandInputTextArea, "Setheading 0.5");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testTowardsExecution() {
    writeInputTo(commandInputTextArea, "Towards 100 200");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testTextAreaClearing() {
    writeInputTo(commandInputTextArea, " \n");
    clickOn(lookup("#ExecuteButton").query());
    assertEquals(0, commandInputTextArea.getText().length());
  }

  @Test
  void testInvalidCommand() {
    writeInputTo(commandInputTextArea, "hi there");
    clickOn(lookup("#ExecuteButton").query());
  }

  @Test
  void testInvalidBackendInitialization() {
    ModelState model = new ModelState(new Preferences(CommandLanguage.ENGLISH));
//    InitializationState initializationState = new InitializationState();
//    assertNull(model.initalizeBackend(initializationState));
    assertNull(model.getUserVariables());
    assertThrows(InvalidCommandLanguageException.class, () -> model.setCommandLanguage("not a language"));
  }
}
