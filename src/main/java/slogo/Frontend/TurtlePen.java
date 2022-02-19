package slogo.Frontend;

import javafx.scene.image.ImageView;
import slogo.FrontendInternalAPIs.DisplayPen;

public class TurtlePen implements DisplayPen {
  public static final double TRANSPARENT = 0;
  public static final double VISIBLE = 1;
  public static final String PEN_IMAGE_PATH = "";

  private ImageView penView;

  public TurtlePen(){

  }
  // Going to have to find different pen color images (or make them) unless javafx can support vector images
  @Override
  public void setPenColor(){

  }

  @Override
  public void setPenSize(){

  }

  @Override
  public void setPenVisible(){
    penView.setOpacity(VISIBLE);
  }
  public void setPenInvisible(){
    penView.setOpacity(TRANSPARENT);
  }

}
