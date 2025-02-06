package sample.todoapp.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.todoapp.animations.Shaker;

public class AddItemController {
  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private ImageView addButton;

  @FXML
  private Label noTaskLabel;

  @FXML
  private AnchorPane rootAnchorPane;

  @FXML
  void initialize() {


    addButton.addEventHandler(
        MouseEvent.MOUSE_CLICKED,
        event -> {
          //change animation for buttons
          Shaker addButtonShaker = new Shaker(addButton);
          addButtonShaker.shake();

          //remove
          System.out.println("Added Clicked!");
          addButton.relocate(0,15);
          noTaskLabel.relocate(0,55);

          FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000),addButton);
          FadeTransition labelTransition = new FadeTransition(Duration.millis(2000), noTaskLabel);

          addButton.setOpacity(0);
          noTaskLabel.setOpacity(0);

          fadeTransition.setFromValue(1f);
          fadeTransition.setToValue(0f);
          fadeTransition.setCycleCount(1);
          fadeTransition.setAutoReverse(false);
          fadeTransition.play();

          labelTransition.setFromValue(1f);
          labelTransition.setToValue(0f);
          labelTransition.setCycleCount(1);
          labelTransition.setAutoReverse(false);
          labelTransition.play();

          try {
            AnchorPane formPane =
                FXMLLoader.load(getClass().getResource("/sample/todoapp/view/addItemForm.fxml"));

            FadeTransition rootTransition = new FadeTransition(Duration.millis(2000), formPane);
            rootTransition.setFromValue(0f);
            rootTransition.setToValue(1f);
            rootTransition.setCycleCount(1);
            rootTransition.setAutoReverse(false);
            rootTransition.play();

            rootAnchorPane.getChildren().setAll(formPane);

          } catch (IOException e) {
            e.printStackTrace();
          }

        });
  }

}
