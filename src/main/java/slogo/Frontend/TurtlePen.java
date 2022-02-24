package slogo.Frontend;

import static slogo.Frontend.ResourceUtil.getResourceColor;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import slogo.FrontendInternalAPIs.DisplayPen;

public class TurtlePen implements DisplayPen {
  public static final double TRANSPARENT = 0;
  public static final double VISIBLE = 1;
  public static final String PEN_IMAGE_PATH = "frontend/pen.png";
  public static final int DEFAULT_SIZE = 30;
  public static final String CONFIGURATION_RESOURCE_PATH =
      TurtlePen.class.getPackage().getClass().getPackageName()
          + "."
          + TurtlePen.class.getPackageName()
          + ".";

  private final ImageView penView;
  private int mySize;
  private ResourceBundle myResources;

  public TurtlePen() {
    setResources(CONFIGURATION_RESOURCE_PATH + "pen");
    penView = new ImageView(PEN_IMAGE_PATH);
    setPenSize(DEFAULT_SIZE);
  }

  /**
   * @author Robert Duvall
   * @author Marcus Ortiz
   * @param filename
   */
  public void setResources(String filename) {
    try {
      myResources = ResourceBundle.getBundle(filename);
    } catch (NullPointerException | MissingResourceException e) {
      throw new IllegalArgumentException(String.format("Invalid resource file: %s", filename));
    }
  }

  // Going to have to find different pen color images (or make them) unless javafx can support
  // vector images
  @Override
  public void setPenColor(String penColor) {
    // This probably won't work
    Color newColor = (Color) getResourceColor(myResources, penColor);
    ColorAdjust colorAdjust = new ColorAdjust();
    colorAdjust.setHue(newColor.getHue());
    colorAdjust.setBrightness(newColor.getBrightness());
    colorAdjust.setSaturation(newColor.getSaturation());
    penView.setEffect(colorAdjust);
  }

  @Override
  public void setPenSize(int size) {
    mySize = size;
    penView.setFitWidth(size);
    penView.setFitHeight(size);
  }

  @Override
  public void setPenVisible() {
    penView.setOpacity(VISIBLE);
  }

  @Override
  public void setPenInvisible() {
    penView.setOpacity(TRANSPARENT);
  }
}
