package slogo.FrontendExternalAPIs;

import javafx.scene.paint.Color;

public interface DisplayCanvas {

  /** clears screen and resets turtle to original position */
  void resetDisplay();

  /** changes background color */
  void  setBackGroundColor(Color color);

}
