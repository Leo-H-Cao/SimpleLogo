package slogo.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import slogo.DukeApplicationTest;
import slogo.SLogoController;

public class ControlPanelTest extends DukeApplicationTest {
  public static final double DEFAULT_SPEED = 1.0;

  private View view;
  private Slider speedSlider;


  @Override
  public void start(Stage stage) {
    SLogoController controller = new SLogoController();
    view = new View(stage, controller);
    speedSlider = lookup("#speedSlider").query();
  }

  @Test
  void testSpeedSlider(){
    assertEquals(speedSlider.getValue(), DEFAULT_SPEED);
    setValue(speedSlider, 3.0);
    assertEquals(speedSlider.getValue(), 3.0);
  }





}
