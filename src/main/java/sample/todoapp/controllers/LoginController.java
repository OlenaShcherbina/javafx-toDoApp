package sample.todoapp.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.todoapp.animations.Shaker;
import sample.todoapp.database.DatabaseHandler;
import sample.todoapp.model.User;

public class LoginController {
  @FXML private ResourceBundle resources;

  @FXML private URL location;

  @FXML private Button loginButton;

  @FXML private PasswordField loginPassword;

  @FXML private Button loginSignupButton;

  @FXML private TextField loginUsername;

  private DatabaseHandler databaseHandler;

  @FXML
  void initialize() {
    databaseHandler = new DatabaseHandler();

    loginButton.setOnAction(
        event -> {
          String loginText = loginUsername.getText().trim();
          String loginPsw = loginPassword.getText().trim();
          User user = new User();
          user.setUserName(loginText);
          user.setPassword(loginPsw);
          ResultSet userRow = databaseHandler.getUser(user);
          int counter = 0;

          try {
            while (userRow.next()) {
              counter++;
              String name = userRow.getString("first_name");
              System.out.println("Welcome!" + name);
            }
            if (counter == 1) {
              //System.out.println("Login Successful!");
              showAddItemScreen();
            } else {
              Shaker userNameShaker = new Shaker(loginUsername);
              Shaker passwordShaker = new Shaker(loginPassword);

              userNameShaker.shake();
              passwordShaker.shake();
            }

          } catch (SQLException e) {
            e.printStackTrace();
          }
        });

    loginSignupButton.setOnAction(
        event -> {
          // take users to signup screen
          loginSignupButton.getScene().getWindow().hide();
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("/sample/todoapp/view/signup.fxml"));
          try {
            loader.load();
          } catch (IOException e) {
            e.printStackTrace();
          }
          Parent root = loader.getRoot();
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.showAndWait();
        });
  }

  private void showAddItemScreen(){
    // take users to addItem screen
    loginSignupButton.getScene().getWindow().hide();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/sample/todoapp/view/addItem.fxml"));
    try {
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Parent root = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.showAndWait();

  }
}
