package slogo.Frontend;

import static slogo.Frontend.ResourceUtil.getResourceColor;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import slogo.FrontendInternalAPIs.DisplayPen;

public class TurtlePen implements DisplayPen {
  private static final String CONFIGURATION_RESOURCE_PATH = "slogo/Frontend/pen";
  private Pane penPane;
  private ResourceBundle myResources;
  private static Color INITIAL_COLOR = Color.BLACK;
  private static double INITIAL_LINE_WIDTH = 5;
  private static boolean INITIAL_PEN_DOWN = true;
  private double strokeWidth;
  private Color penColor;
  private boolean penDown;


  public TurtlePen() {
    setResources();
    penPane = new Pane();
    penColor = Color.valueOf(myResources.getString("defaultPenColor"));
    penDown = Boolean.parseBoolean(myResources.getString("defaultPenDown"));
    strokeWidth = Double.parseDouble(myResources.getString("defaultPenWidth"));
  }

  public void setResources() {
    try {
      myResources = ResourceBundle.getBundle(CONFIGURATION_RESOURCE_PATH, Locale.ENGLISH);
    } catch (NullPointerException | MissingResourceException e) {
      throw new IllegalArgumentException(String.format("Invalid resource file: %s", "pen"));
    }
  }

  // Going to have to find different pen color images (or make them) unless javafx can support
  // vector images
  @Override
  public void setPenColor(Color color) {
    penColor = color;
  }

  @Override
  public void setPenSize(int size) {
    strokeWidth = size;
  }

  @Override
  public void setPenVisible(boolean down) {
    penDown = down;

  }

  @Override
  public void setGCOptions(GraphicsContext gc) {
    gc.setStroke(penColor);
    gc.setLineWidth(strokeWidth);
  }
}
