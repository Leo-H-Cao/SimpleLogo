package slogo.Frontend.ToolBarButtons;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import slogo.Frontend.TurtlePen;

public class PenColorButton{
  private static final String PEN_COLOR_LABEL = "  Pen Color:";

  private ColorPicker colorPicker;
  private HBox colorPickerContainer;

  public PenColorButton(TurtlePen turtlePen){
    colorPickerContainer = new HBox();
    colorPickerContainer.getStyleClass().add("color-picker-container");
    colorPicker = new ColorPicker(Color.BLACK);
    colorPicker.setOnAction(ActionEvent -> {
      turtlePen.setPenColor(colorPicker.getValue());
    });
    layoutColorPicker();
  }

  private void layoutColorPicker(){
    colorPickerContainer.setAlignment(Pos.CENTER);
    Label label = new Label(PEN_COLOR_LABEL);
    colorPickerContainer.getChildren().addAll(label, colorPicker);
  }

  public HBox getColorPickerContainer(){
    return colorPickerContainer;
  }

}
