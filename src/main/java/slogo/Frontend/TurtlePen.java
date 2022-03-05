package slogo.Frontend;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import slogo.FrontendInternalAPIs.DisplayPen;

/**
 * Pen object that keeps track of stroke width, pen color, pen down
 * @author Leo Cao
 */
public class TurtlePen implements DisplayPen {
  private static final String CONFIGURATION_RESOURCE_PATH = "slogo/Frontend/pen";
  private ResourceBundle myResources;
  private double strokeWidth;
  private double currentStrokeWidth;
  private Color penColor;
  private boolean penDown;


  public TurtlePen() {
    setResources();
    penColor = Color.valueOf(myResources.getString("defaultPenColor"));
    penDown = Boolean.parseBoolean(myResources.getString("defaultPenDown"));
    strokeWidth = Double.parseDouble(myResources.getString("defaultPenWidth"));
    currentStrokeWidth = Double.parseDouble(myResources.getString("defaultPenWidth"));
  }

  public void setResources() {
    try {
      myResources = ResourceBundle.getBundle(CONFIGURATION_RESOURCE_PATH, Locale.ENGLISH);
    } catch (NullPointerException | MissingResourceException e) {
      throw new IllegalArgumentException(String.format("Invalid resource file: %s", "pen"));
    }
  }

  /**
   * Sets new pen color, black is default
   * @param color
   */
  @Override
  public void setPenColor(Color color) {
    penColor = color;
  }

  /**
   * sets new stroke width, 5 is default
   * @param size
   */
  @Override
  public void setPenSize(int size) {
    strokeWidth = size;
  }

  /**
   * sets pen down
   * @param down
   */
  @Override
  public void setPenVisible(boolean down) {
    if(!down){
      currentStrokeWidth = 0;
    }
    else{
      currentStrokeWidth = strokeWidth;
    }
  }

  /**
   * Configures graphics context to current pen settings
   * @param gc
   */
  @Override
  public void setGCOptions(GraphicsContext gc) {
    gc.setStroke(penColor);
    gc.setLineWidth(currentStrokeWidth);
  }
}
