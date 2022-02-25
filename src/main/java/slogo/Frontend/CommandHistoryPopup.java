package slogo.Frontend;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import slogo.Backend.State.CommandHistory;

public class CommandHistoryPopup {
  public final int POPUP_X_LOCATION = 400;
  public final int POPUP_Y_LOCATION = 150;
  public final int TOP_BAR_SPACING = 325;
  public static final String LABEL_TEXT = "Command History";

  private Popup myPopup;
  private Pane layout;

  public CommandHistoryPopup(CommandHistory commandHistory){
    myPopup = new Popup();
    layout = new VBox();
    layout.getStyleClass().add("command-history-popup");
    myPopup.getContent().add(layout);
    setLayout();
    myPopup.setX(POPUP_X_LOCATION);
    myPopup.setY(POPUP_Y_LOCATION);

    layout.setId("CommandHistoryPopup");
  }

  public Popup getPopup(){
    return myPopup;
  }

  private void setLayout(){
    Button closeButton = new Button("close");
    closeButton.setOnAction(actionEvent -> {
      myPopup.hide();
    });
    Label label = new Label(LABEL_TEXT);
    Pane topBar = new HBox(TOP_BAR_SPACING);
    topBar.getStyleClass().add("command-history-popup-top");
    topBar.getChildren().addAll(label, closeButton);
    layout.getChildren().addAll(topBar);
  }
}
