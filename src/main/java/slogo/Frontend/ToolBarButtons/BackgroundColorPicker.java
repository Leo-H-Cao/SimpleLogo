package slogo.Frontend.ToolBarButtons;

import slogo.Frontend.TurtleBackground;

public class BackgroundColorPicker extends ColorPickerAbstract {
  private static final String BACKGROUND_COLOR_LABEL = "  Background Color:";

  public BackgroundColorPicker(TurtleBackground turtleBackground){
      super(BACKGROUND_COLOR_LABEL);
    colorPicker.setOnAction(ActionEvent -> {
      turtleBackground.setBackGroundColor(colorPicker.getValue());
    });
  }
}

