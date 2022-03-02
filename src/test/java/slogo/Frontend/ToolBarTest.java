package slogo.Frontend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

public class ToolBarTest extends DukeApplicationTest {
  private static final String DEFAULT_LANGUAGE = "English";
  private static final String VALID_COLOR = "#fff1a0";
  private static final String INVALID_COLOR = "#fff1az";
  private static final String INVALID_COLOR_ERROR_MSG = "Invalid hex representation";
  private static final String NO_COLOR_ERROR_MSG = "You have not entered a color";

  private View view;
  private ToolBar toolBar;
  private Button commandHistoryButton;
  private ChoiceBox selectLanguageChoiceBox;
  private Button backgroundColorButton;
  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    toolBar = lookup("#ToolBar").query();
    commandHistoryButton = lookup("#CommandHistoryButton").query();
    selectLanguageChoiceBox = lookup("#SelectDisplayLanguage").query();
    backgroundColorButton = lookup("#BackgroundColorButton").query();
  }

  @Test
  void testCommandHistoryOpen(){
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
    clickOn(commandHistoryButton);
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
  }

  @Test
  void testCommandHistoryClose(){
    clickOn(commandHistoryButton);
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
    clickOn(lookup("#CloseCommandHistory").query());
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
  }

  @Test
  void testChangeLanguage(){
    assertTrue(selectLanguageChoiceBox.isVisible());
    assertEquals(selectLanguageChoiceBox.getSelectionModel().getSelectedItem().toString(), DEFAULT_LANGUAGE);
    select(selectLanguageChoiceBox, "Language 2");
    assertEquals(selectLanguageChoiceBox.getValue(), "Language 2");
  }

  @Test
  void testChangeBackgroundColorOpen(){
    assertEquals(lookup("#BackgroundColorPopup").tryQuery(), Optional.empty());
    clickOn(backgroundColorButton);
    assertTrue(lookup("#BackgroundColorPopup").query().isVisible());
  }

  @Test
  void testChangeBackgroundValidInput(){
    clickOn(backgroundColorButton);
    writeInputTo( lookup("#BackgroundColorTextField").query(), VALID_COLOR);
    clickOn(lookup("#BackgroundColorSubmit").query());
    assertEquals(lookup("#BackgroundColorPopup").tryQuery(), Optional.empty());
  }

  @Test
  void testChangeBackgroundInvalidInput(){
    clickOn(backgroundColorButton);
    writeInputTo( lookup("#BackgroundColorTextField").query(), INVALID_COLOR);
    clickOn(lookup("#BackgroundColorSubmit").query());
    assertTrue(lookup("#BackgroundColorPopup").query().isVisible());
    assertEquals(((Label)lookup("#BackgroundColorError").query()).getText(), INVALID_COLOR_ERROR_MSG);
  }

  @Test
  void testChangeBackgroundEmptyInput(){
    clickOn(backgroundColorButton);
    writeInputTo( lookup("#BackgroundColorTextField").query(), "");
    clickOn(lookup("#BackgroundColorSubmit").query());
    assertTrue(lookup("#BackgroundColorPopup").query().isVisible());
    assertEquals(((Label)lookup("#BackgroundColorError").query()).getText(), NO_COLOR_ERROR_MSG);
  }
}
