package slogo.Frontend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

public class ToolBarTest extends DukeApplicationTest {
  public static final String DEFAULT_LANGUAGE = "English";

  private View view;
  private ToolBar toolBar;
  private Button commandHistoryButton;
  private ChoiceBox selectLanguageChoiceBox;

  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    toolBar = lookup("#ToolBar").query();
    commandHistoryButton = lookup("#CommandHistoryButton").query();
    selectLanguageChoiceBox = lookup("#SelectDisplayLanguage").query();
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






}
