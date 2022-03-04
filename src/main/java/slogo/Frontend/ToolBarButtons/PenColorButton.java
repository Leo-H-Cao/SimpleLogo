package slogo.Frontend.ToolBarButtons;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import slogo.Frontend.TurtlePen;
import slogo.Frontend.TurtleView;

public class PenColorButton{

  private ColorPicker colorPicker;

  public PenColorButton(TurtlePen turtlePen){
    colorPicker = new ColorPicker(Color.BLACK);
    colorPicker.setOnAction(ActionEvent -> {
      turtlePen.setPenColor(colorPicker.getValue());
    });
  }

  public ColorPicker getColorPicker(){
    return colorPicker;
  }

}
