package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import slogo.Frontend.TurtleView;


public class TurtleImageChooserButton extends ToolBarButtonAbstract{

  private FileChooser fileChooser;

  public TurtleImageChooserButton(String buttonName, TurtleView currentTurtleView) {
    super(buttonName);
    fileChooser = new FileChooser();
    setOnClick(currentTurtleView);
  }

  private void setOnClick(TurtleView currentTurtleView){
    myButton.setOnAction(actionEvent -> {
      File file = fileChooser.showOpenDialog(stage);
      if (file != null && validateFile(file.getName())) {
        Image newTurtleImage = new Image(file.toURI().toString());
        currentTurtleView.setTurtleImage(newTurtleImage);
      }
      else{
        //TODO: Display error for invalid image
      }
    });
  }

  private boolean validateFile(String str){
    String regex
        = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$)";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(str);
    return matcher.matches();
  }
}
