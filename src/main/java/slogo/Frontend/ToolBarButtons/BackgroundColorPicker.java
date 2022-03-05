package slogo.Frontend.ToolBarButtons;

import javafx.scene.paint.Color;
import slogo.Frontend.TurtleBackground;

public class BackgroundColorPicker extends ColorPickerAbstract {
  private static final String BACKGROUND_COLOR_LABEL = "  Background:";

  /**
   * color picker for background color of turtle display
   * @param turtleBackground
   */
  public BackgroundColorPicker(TurtleBackground turtleBackground){
    super(BACKGROUND_COLOR_LABEL);
    colorPicker.setValue(Color.ALICEBLUE);
    colorPicker.setOnAction(ActionEvent -> {
      turtleBackground.setBackGroundColor(colorPicker.getValue());
    });
    colorPicker.setId("BackgroundColorPicker");
  }
}

