package slogo.Frontend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

public class ToolBarTest extends DukeApplicationTest {
  private View view;
  private ToolBar toolBar;

  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    toolBar = lookup("#ToolBar").query();
  }

  @Test
  void testCommandHistoryOpen(){
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
    clickOn(lookup("#CommandHistoryButton").query());
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
  }

  @Test
  void testCommandHistoryClose(){
    clickOn(lookup("#CommandHistoryButton").query());
    assertTrue(lookup("#CommandHistoryPopup").query().isVisible());
    clickOn(lookup("#CloseCommandHistory").query());
    assertEquals(lookup("#CommandHistoryPopup").tryQuery(), Optional.empty());
  }



}
