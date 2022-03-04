package slogo.Frontend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

public class ToolBarTest extends DukeApplicationTest {
  private static final String DEFAULT_LANGUAGE = "English";

  private View view;

  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    clickOn(lookup("#StartButton").query());
  }

  @Test
  void testCommandHistoryOpen(){
    Button commandHistoryButton = lookup("#CommandHistoryButton").query();
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
    clickOn(commandHistoryButton);
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
  }

  @Test
  void testCommandHistoryClose(){
    Button commandHistoryButton = lookup("#CommandHistoryButton").query();
    clickOn(commandHistoryButton);
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
    clickOn(lookup("#CloseCommandHistory").query());
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
  }

  @Test
  void testChangeLanguage(){
    ChoiceBox selectLanguageChoiceBox = lookup("#SelectDisplayLanguage").query();
    assertTrue(selectLanguageChoiceBox.isVisible());
    assertEquals(selectLanguageChoiceBox.getSelectionModel().getSelectedItem().toString(), DEFAULT_LANGUAGE);
    select(selectLanguageChoiceBox, "Language 2");
    assertEquals(selectLanguageChoiceBox.getValue(), "Language 2");
  }

}
