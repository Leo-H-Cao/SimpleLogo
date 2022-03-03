package slogo.Frontend.ToolBarButtons;

import static slogo.Frontend.View.stage;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.FileChooser;


public class TurtleImageChooserButton extends ToolBarButtonAbstract{

  private FileChooser fileChooser;

  public TurtleImageChooserButton(String buttonName) {
    super(buttonName);
    fileChooser = new FileChooser();
    setOnClick();
  }

  private void setOnClick(){
    myButton.setOnAction(actionEvent -> {
      File file = fileChooser.showOpenDialog(stage);
      if (file != null && validateFile(file.getName())) {
        //TODO: Handle changing image for turtle
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
