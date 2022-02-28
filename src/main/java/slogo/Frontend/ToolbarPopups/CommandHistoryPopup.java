package slogo.Frontend.ToolbarPopups;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import slogo.Backend.State.CommandHistory;

public class CommandHistoryPopup extends ToolbarPopupsAbstract{
  public final int TOP_BAR_SPACING = 325;
  public static final String LABEL_TEXT = "Command History";

  private final double POPUP_X_LOCATION = 400;
  private final double POPUP_Y_LOCATION = 150;
  private Pane layout;


  public CommandHistoryPopup(CommandHistory commandHistory){
    super();
    this.setLocation(POPUP_X_LOCATION, POPUP_Y_LOCATION);

    layout = new VBox();
    layout.getStyleClass().add("command-history-popup");
    myPopup.getContent().add(layout);
    setLayout();

    layout.setId("CommandHistoryPopup");
  }

  @Override
  void setLayout(){
    Button closeButton = new Button("close");
    closeButton.setId("CloseCommandHistory");
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
