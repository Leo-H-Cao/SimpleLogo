package slogo.Frontend.ToolBarButtons;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import slogo.Frontend.TurtlePen;

public abstract class ColorPickerAbstract {

  ColorPicker colorPicker;
  HBox colorPickerContainer;
  String myButtonLabel;

  public ColorPickerAbstract(String buttonLabel){
    colorPickerContainer = new HBox();
    myButtonLabel = buttonLabel;
    colorPickerContainer.getStyleClass().add("color-picker-container");
    colorPicker = new ColorPicker(Color.BLACK);
    layoutColorPicker();
  }

  private void layoutColorPicker(){
    colorPickerContainer.setAlignment(Pos.CENTER);
    Label label = new Label(myButtonLabel);
    colorPickerContainer.getChildren().addAll(label, colorPicker);
  }

  public HBox getColorPickerContainer(){
    return colorPickerContainer;
  }


}
