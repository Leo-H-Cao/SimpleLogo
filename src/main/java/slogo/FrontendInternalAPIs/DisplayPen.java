package slogo.FrontendInternalAPIs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public interface DisplayPen {

  void setPenColor(Color color);

  void setPenSize(int size);

  void setPenVisible(boolean down);

  void setGCOptions(GraphicsContext gc);
}
