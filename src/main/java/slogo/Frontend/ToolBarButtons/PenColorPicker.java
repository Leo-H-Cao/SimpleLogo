package slogo.Frontend.ToolBarButtons;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import slogo.Frontend.TurtlePen;

public class PenColorPicker extends ColorPickerAbstract {
  private static final String PEN_COLOR_LABEL = "  Pen:";

  /**
   * color picker for pen color for drawing turtle tracks
   * @param turtlePen
   */
  public PenColorPicker(TurtlePen turtlePen){
    super(PEN_COLOR_LABEL);
    colorPicker.setOnAction(ActionEvent -> {
      turtlePen.setPenColor(colorPicker.getValue());
    });
  }


}
