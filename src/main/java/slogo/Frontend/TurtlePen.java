package slogo.Frontend;

import java.util.HashMap;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import slogo.FrontendInternalAPIs.DisplayPen;
import slogo.Main;

public class TurtlePen implements DisplayPen {
  public static final double TRANSPARENT = 0;
  public static final double VISIBLE = 1;
  public static final String PEN_IMAGE_PATH = "frontend/pen.png";
  public static final int DEFAULT_SIZE = 30;


  private ImageView penView;
  private int mySize;

  public TurtlePen(){
    penView = new ImageView(PEN_IMAGE_PATH);
    setPenSize(DEFAULT_SIZE);
  }
  // Going to have to find different pen color images (or make them) unless javafx can support vector images
  @Override
  public void setPenColor(String penColor){
    // Could use refraction to change it using a resource file
//    Color targetColor = Color.color;
  }

  @Override
  public void setPenSize(int size){
    mySize = size;
    penView.setFitWidth(size);
    penView.setFitHeight(size);
  }

  @Override
  public void setPenVisible(){
    penView.setOpacity(VISIBLE);
  }
  public void setPenInvisible(){
    penView.setOpacity(TRANSPARENT);
  }

}
